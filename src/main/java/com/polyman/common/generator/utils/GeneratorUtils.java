package com.polyman.common.generator.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.polyman.common.generator.bean.GeneratorColumnBean;
import com.polyman.common.generator.bean.GeneratorTable;
import com.polyman.common.generator.config.ConfigBean;
import com.polyman.common.generator.constants.ConstVal;
import com.polyman.common.generator.enums.DbColumnType;
import com.polyman.common.generator.enums.DbType;
import com.polyman.common.generator.enums.FiledDisplay;
import com.polyman.common.generator.enums.QueryModeType;
import com.polyman.common.generator.template.TemplateVm;
import com.polyman.common.generator.typeconvert.TypeConvert;
import com.polyman.common.generator.typeconvert.TypeConvertFactory;

/**
 * 代码生成器   工具类
 */
@Component
public class GeneratorUtils {

	@Autowired
	private TypeConvertFactory typeConvertFactory;
	
	@Autowired
	private List<TemplateVm> templateVmList;
	
	@Autowired
	private DataSourceProperties dataSourceProperties;
	
	private static final Logger logger = LoggerFactory.getLogger(GeneratorUtils.class);
	
	/**
	 * 生成代码
	 */
	public  void generatorCode(GeneratorTable table,ConfigBean config, ByteArrayOutputStream outputStream) {
		String dbType=config.getDbType();
		TypeConvert typeConvert=typeConvertFactory.getTypeConvert(DbType.getDbTypeByValue(dbType));
		//封装模板数据
		String packageName=config.getPackageName();
		String module=table.getModuleName();
		String beanName=table.getBeanName();
		String BeanName=NamingStrategy.capitalFirst(beanName);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("datasourceUrl", dataSourceProperties.getUrl());
		map.put("datasourceUsername", dataSourceProperties.getUsername());
		map.put("datasourcePassword", dataSourceProperties.getPassword());
			
		map.put("tableName", table.getTableName());
		map.put("beanName", beanName);
		map.put("BeanName", BeanName);
		map.put("beanname", beanName.toLowerCase());
		map.put("modulename", module);
		map.put("comments", table.getTableComment());

		if(StringUtils.hasLength(module)){
			map.put("modulePath", "/"+module);
			map.put("modulePackage", "."+module);
			map.put("moduleRight", module+":");
		}else{
			map.put("modulePath", "");
			map.put("modulePackage", "");
			map.put("moduleRight", "");
		}
		
		map.put("author", config.getAuthor());
		map.put("email", config.getEmail());
		map.put("baseDao", config.getSuperDaoClass());
		map.put("parentModuleName", config.getParentModuleName());
		map.put("apiModuleName", config.getApiModuleName());
		map.put("srvModuleName", config.getSrvModuleName());
		map.put("webModuleName", config.getWebModuleName());
		map.put("version", config.getVersion());
		map.put("swaggerFlag", config.getSwaggerFlag());
		map.put("shiroFlag", config.getShiroFlag());

		map.put("superControllerClass", config.getSuperControllerClass());
		map.put("bizExceptionPath", config.getBizExceptionPath());
		//异常名称不一样
		map.put("bizExceptionName", config.getBizExceptionPath().substring(config.getBizExceptionPath().lastIndexOf(".")+1));
		
		map.put("superRequestClass", config.getSuperRequestClass());
		map.put("projectName", config.getProjectName());
		map.put("ProjectName", NamingStrategy.capitalFirst(config.getProjectName()));
		
		map.put("datetime", DateUtil.format(DateUtil.TIME_PATTERN_CH, new Date()));
		map.put("packageName", packageName);
		
	
		Set<String> pkgList=new HashSet<>();
		map.put("pkgList", pkgList);
		
		Set<String> pkgTypeList=new HashSet<>();
		map.put("pkgTypeList", pkgTypeList);
		
		
		List<Map<String, Object>> columnList = new ArrayList<>();
		map.put("columns", columnList);
		for(GeneratorColumnBean column : table.getColumns()){
			Map<String, Object> columnMap=new HashMap<>();
			columnMap.put("columnKey", column.getColumnKey());
			
			columnMap.put("autoIncrement", column.getAutoIncrement());
			    map.put("autoIncrement", true);
			columnMap.put("columnName", column.getColumnName());
			String propertyName=column.getPropertyName();
			
			columnMap.put("propertyName", propertyName);
			columnMap.put("PropertyName", NamingStrategy.capitalFirst(propertyName));
			columnMap.put("propertyname", propertyName.toLowerCase());
			columnMap.put("columnComment", column.getColumnComment());
			
			List<String> annotationList=new ArrayList<>();
			columnMap.put("annotationList", annotationList);
			
			columnMap.put("isNull", column.getIsNull());
			if("1".equals(column.getIsNull())){
				 annotationList.add("@NotNull(message=\""+propertyName+"不能为空\")");
				 pkgList.add("javax.validation.constraints.NotNull");
			}	

			
			String dataType=column.getDataType();
			columnMap.put("dataType", dataType);
			
			DbColumnType dbColumnType=typeConvert.processTypeConvert(dataType);
			columnMap.put("javaDataType", dbColumnType.getType());
			
			if("1".equals(column.getColumnKey())){
				map.put("pk", column.getColumnName());
				map.put("pkPropertyName", column.getPropertyName());
				map.put("pkJavaDataType", dbColumnType.getType());
			}
			
			
			if(dbColumnType.equals(DbColumnType.STRING)){
				annotationList.add("@Size(max ="+column.getLength()+",message=\""+propertyName+"长度超长\")");
				pkgList.add("javax.validation.constraints.Size");
			}
			if(dbColumnType.equals(DbColumnType.BIG_DECIMAL)){
				annotationList.add("@Digits(integer="+column.getNumberPre()+",fraction="+column.getNumberScale()+",message=\""+propertyName+"格式错误\")");
				pkgList.add("javax.validation.constraints.Digits");
			}
		
			if(null != dbColumnType.getPkg()){
				pkgTypeList.add(dbColumnType.getPkg());
			}
			
			columnMap.put("length", column.getLength());
			columnMap.put("numberPre", column.getNumberPre());
			columnMap.put("numberScale", column.getNumberScale());
			
			int number=column.getDisplay();
			columnMap.put("addCol", FiledDisplay.isAdd(number));
			columnMap.put("updataCol", FiledDisplay.isUpdate(number));
			columnMap.put("queryCol", FiledDisplay.isQuery(number));
			columnMap.put("viewCol", FiledDisplay.isView(number));
			columnMap.put("queryModel", column.getQueryModel());
			columnMap.put("op", QueryModeType.getOp(column.getQueryModel()));
			
			
			if(column.getQueryModel().indexOf(QueryModeType.IN.getType()) != -1){
				pkgTypeList.add("java.util.Set");
			}
			columnList.add(columnMap);
		}
		//设置velocity资源加载器
		Properties prop = new Properties();  
		prop.put(ConstVal.VM_LOADPATH_KEY, ConstVal.VM_LOADPATH_VALUE);  
		prop.setProperty(Velocity.ENCODING_DEFAULT, ConstVal.UTF8);
		prop.setProperty(Velocity.INPUT_ENCODING, ConstVal.UTF8);
		Velocity.setProperty(VelocityEngine.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.NullLogChute"); 
		Velocity.init(prop);
		
        VelocityContext context = new VelocityContext(map);
        OutputStream os  = null;
        ZipOutputStream zip = new ZipOutputStream(outputStream);
		        //获取模板列表
				for(TemplateVm templateVm : templateVmList){
					if(!templateVm.isBulid()){
						continue;
					}
					//渲染模板
					StringWriter sw = new StringWriter();
					Template tpl = Velocity.getTemplate(templateVm.getPathName(), ConstVal.UTF8);
					tpl.merge(context, sw);
					try {
						String packagePath=ConstVal.CLASS_PATH;
						
						
						if(StringUtils.hasLength(packageName)){
							packagePath += packageName.replace(".", File.separator) + File.separator;
						}
						
						String tempModule=module;
						if(StringUtils.hasLength(module)){
							tempModule =tempModule+ File.separator;
						}else{
							tempModule="";
						}
						StringBuffer fileName=new StringBuffer();
						if(StringUtils.hasLength(config.getFileDirectory())){
							fileName.append(config.getFileDirectory()).append(File.separator);
						}
						if(StringUtils.hasLength(config.getParentModuleName())){
							fileName.append(config.getParentModuleName()).append(File.separator);
						}
						
						if(StringUtils.hasLength(templateVm.getProjectName())){
							fileName.append(templateVm.getProjectName()).append(File.separator);
						}
						fileName.append(templateVm.getFileName(packagePath,tempModule, BeanName));
						logger.info("filename path={}",fileName.toString());
						createNewFile(fileName.toString());
					
						os = new BufferedOutputStream(new FileOutputStream(fileName.toString()));
						os.write(sw.toString().getBytes(ConstVal.UTF8));
						os.close();
						
						zip.putNextEntry(new ZipEntry(fileName.toString()));  
						zip.write(sw.toString().getBytes(ConstVal.UTF8));
						zip.closeEntry();
					} catch (IOException e) {
						System.out.println("渲染模板失败，表名：" + map.get("tableName") +e.getMessage());
					}
		 }
				
	}
	
	/**
	 * 在指定路径创建新文件，自动创建上级目录
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static File createNewFile(String path) {
		if (StringUtils.isEmpty(path)) {
			return null;
		}

		File file = new File(path);
		return (createNewFile(file) ? file : null);
	}

	/**
	 * 创建新文件，自动创建上级目录
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static boolean createNewFile(File file) {
		if (file == null) {
			return false;
		}

		if (file.exists()) {
			return true;
		}

		mkParentDirs(file);

		try {
			return file.createNewFile();
		} catch (IOException ie) {
			throw new RuntimeException("Create file error", ie);
		}
	}

	/**
	 * 自动创建上级目录
	 * 
	 * @param file
	 * @return
	 */
	public static boolean mkParentDirs(String path) {
		if (StringUtils.isEmpty(path)) {
			return false;
		}

		return mkParentDirs(new File(path));
	}

	/**
	 * 自动创建上级目录
	 * 
	 * @param file
	 * @return
	 */
	public static boolean mkParentDirs(File file) {
		if (file == null) {
			return false;
		}

		File parentFile = file.getParentFile();
		if (parentFile == null) {
			return true;
		}

		if (parentFile.exists() == false) {
			return parentFile.mkdirs();
		}

		return true;
	}

}
