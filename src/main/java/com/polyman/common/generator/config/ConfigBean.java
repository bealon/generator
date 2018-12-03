package com.polyman.common.generator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.polyman.common.generator.enums.DbType;



@Component
@ConfigurationProperties(prefix="generator.config")
public class ConfigBean {

	private String author;
	 
	private String email;
	
	private String packageName;
	
	private String dbType=DbType.MYSQL.getValue(); 
	
	private String fileDirectory;
	
	private String superRequestClass;
	
	private String superDaoClass ;
    /**
     * 自定义继承的Controller类全称，带包名
     */
    private String superControllerClass;
	/**
	 * 自定义业务异常类
	 */
	private String bizExceptionPath;
    /**
     * 父模块名称
     */
	private String parentModuleName;
    /**
     * 接口模块名称
     */
    private String apiModuleName  ;

    /**
     * 实现模块名称
     */
    private String srvModuleName ;
    
    /**
     * web层模块名称
     */
    private String webModuleName ;
    
    
    private String version;
    /**
     * 项目打包名称
     */
    private String projectName ; 
    /**
     * swagger 标志
     */
    private boolean swaggerFlag;
    /**
     * shiro 标志
     */
    private boolean shiroFlag;
    
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getBizExceptionPath() {
		return bizExceptionPath;
	}

	public void setBizExceptionPath(String bizExceptionPath) {
		this.bizExceptionPath = bizExceptionPath;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getSuperDaoClass() {
		return superDaoClass;
	}

	public void setSuperDaoClass(String superDaoClass) {
		this.superDaoClass = superDaoClass;
	}

	public String getSuperControllerClass() {
		return superControllerClass;
	}

	public void setSuperControllerClass(String superControllerClass) {
		this.superControllerClass = superControllerClass;
	}

	public String getFileDirectory() {
		return fileDirectory;
	}

	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}

	public String getSuperRequestClass() {
		return superRequestClass;
	}

	public void setSuperRequestClass(String superRequestClass) {
		this.superRequestClass = superRequestClass;
	}

	public String getApiModuleName() {
		return apiModuleName;
	}

	public void setApiModuleName(String apiModuleName) {
		this.apiModuleName = apiModuleName;
	}

	public String getSrvModuleName() {
		return srvModuleName;
	}

	public void setSrvModuleName(String srvModuleName) {
		this.srvModuleName = srvModuleName;
	}

	public String getWebModuleName() {
		return webModuleName;
	}

	public void setWebModuleName(String webModuleName) {
		this.webModuleName = webModuleName;
	}

	public String getParentModuleName() {
		return parentModuleName;
	}

	public void setParentModuleName(String parentModuleName) {
		this.parentModuleName = parentModuleName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public boolean getSwaggerFlag() {
		return swaggerFlag;
	}

	public void setSwaggerFlag(boolean swaggerFlag) {
		this.swaggerFlag = swaggerFlag;
	}

	public boolean getShiroFlag() {
		return shiroFlag;
	}

	public void setShiroFlag(boolean shiroFlag) {
		this.shiroFlag = shiroFlag;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
