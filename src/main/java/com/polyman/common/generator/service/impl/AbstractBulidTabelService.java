package com.polyman.common.generator.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polyman.common.generator.bean.GeneratorColumnBean;
import com.polyman.common.generator.bean.GeneratorTable;
import com.polyman.common.generator.config.ConfigBean;
import com.polyman.common.generator.config.ConfigTabelPolicyBean;
import com.polyman.common.generator.model.MetaColumn;
import com.polyman.common.generator.model.MetaTable;
import com.polyman.common.generator.service.GeneratorService;
import com.polyman.common.generator.utils.GeneratorUtils;
import com.polyman.common.generator.utils.NamingStrategy;

@Service
public abstract class AbstractBulidTabelService implements GeneratorService {

	@Autowired
	private GeneratorUtils genUtils;

	@Autowired
	protected ConfigBean generatorConfigBean;

	@Autowired
	protected ConfigTabelPolicyBean configTabelPolicyBean;

	public GeneratorTable initDate(MetaTable tempTable) {

		GeneratorTable generatorTable = new GeneratorTable();
		generatorTable.setTableSchema(configTabelPolicyBean.getTableSchema());

		List<GeneratorColumnBean> columns = new ArrayList<>();
		generatorTable.setColumns(columns);

		String tableName = tempTable.getTableName();
		generatorTable.setTableName(tableName);
		generatorTable.setTableComment(tempTable.getTableComment());

		if (configTabelPolicyBean.isHasMoudule()) {
			String moduleName = NamingStrategy.getMoudule(tableName);
			tableName = NamingStrategy.removePrefix(tableName, moduleName);

			generatorTable.setModuleName(moduleName);
		}

		String beanName = tableName;
		if (configTabelPolicyBean.getTableNamingStrategy().equals(NamingStrategy.underline_to_camel)) {
			beanName = NamingStrategy.underlineToCamel(tableName);
		}
		generatorTable.setBeanName(beanName);
		// 列数据
		List<MetaColumn> columnLs = getColumnList(tempTable.getTableName());
		for (MetaColumn column : columnLs) {
			GeneratorColumnBean generatorColumnBean = new GeneratorColumnBean();

			generatorColumnBean.setColumnName(column.getColumnName());
			generatorColumnBean.setColumnKey(column.getColumnKey());
			generatorColumnBean.setAutoIncrement(column.getAutoIncrement());
			
			
			String propertyName = column.getColumnName();
			if (configTabelPolicyBean.getColNamingStrategy().equals(NamingStrategy.underline_to_camel)) {
				propertyName = NamingStrategy.underlineToCamel(column.getColumnName());
			}
			
			generatorColumnBean.setPropertyName(propertyName);
			
			generatorColumnBean.setIsNull(column.getIsNull());
			generatorColumnBean.setDataType(column.getDataType());
			generatorColumnBean.setLength(column.getStringLength());
			generatorColumnBean.setNumberPre(column.getNumberPre());
			generatorColumnBean.setNumberScale(column.getNumberScale());
			//设置默认值
			generatorColumnBean.setQueryModel("0");;
			generatorColumnBean.setDisplay(11);
			
			String columnComment=column.getColumnComment();
			if(null != columnComment){
				String [] columnComments=columnComment.split(";");
				switch(columnComments.length){
				    case 3:
				    	generatorColumnBean.setDisplay(Integer.valueOf(columnComments[2]));
				    case 2:
				    	generatorColumnBean.setQueryModel(columnComments[1]);
				    case 1:	
				    	generatorColumnBean.setColumnComment(columnComments[0]);
				    	break;
				}
			}
			columns.add(generatorColumnBean);
		}
		return generatorTable;
	}

	public void bulidCode() {
		List<String> allowedTables = configTabelPolicyBean.getAllowedTables();
		// 拒绝策略优先
		List<String> refuseTables = configTabelPolicyBean.getRefuseTables();

		List<MetaTable> tableLs = getTableList();

		for (MetaTable tempTable : tableLs) {
			String tableName = tempTable.getTableName();
			if ((refuseTables.size() != 0 && refuseTables.contains(tableName))
					|| (refuseTables.size() == 0 && allowedTables.size() != 0 && !allowedTables.contains(tableName))) {
				continue;
			}
			GeneratorTable generatorTable = initDate(tempTable);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			genUtils.generatorCode(generatorTable,generatorConfigBean, outputStream);
		}
	}

	public abstract List<MetaTable> getTableList();

	public abstract List<MetaColumn> getColumnList(String tableName);

}
