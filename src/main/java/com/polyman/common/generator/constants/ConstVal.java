package com.polyman.common.generator.constants;

import java.io.File;
import java.nio.charset.Charset;

public class ConstVal {

	public static final String MYSQL = "mysql";
	public static final String POSTGRE = "postger";

	public static final String CLASS_PATH= "src" + File.separator+"main" + File.separator + "java" + File.separator;
	public static final String RESOURCES_PATH= "src" + File.separator+"main" + File.separator + "resources" + File.separator;
	public static final String MKDIR_PATH="/";

	public static final String JAVA_TMPDIR = "java.io.tmpdir";
	public static final String UTF8 = Charset.forName("UTF-8").name();
	public static final String UNDERLINE = "_";


	public static final String VM_LOADPATH_KEY = "file.resource.loader.class";
	public static final String VM_LOADPATH_VALUE = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader";

	public static final String PROFILE_SINGLE = "single";
	public static final String PROFILE_MULTI = "multi";
}
