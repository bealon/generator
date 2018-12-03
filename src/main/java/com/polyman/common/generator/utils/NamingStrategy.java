
package com.polyman.common.generator.utils;

import com.polyman.common.generator.constants.ConstVal;

/**
 * 表名命名规则   1  驼峰写法    2  小写+下划线
 */
public enum NamingStrategy {
    /**
     * 不做任何改变，原样输出
     */
    nochange,
    /**
     * 下划线转驼峰命名
     */
    underline_to_camel;

    public static String underlineToCamel(String name) {
        // 快速检查
        if (isEmpty(name)) {
            // 没必要转换
            return "";
        }
        String tempName = name;
  
        StringBuilder result = new StringBuilder();
        // 用下划线将原始字符串分割
        String camels[] = tempName.split(ConstVal.UNDERLINE);
        if(camels.length==1){
        	return name;
        }
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (isEmpty(camel)) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(capitalFirst(camel));
            }
        }
        return result.toString();
    }

    
    public static String getMoudule(String name){
    	 // 快速检查
        if (isEmpty(name)) {
            // 没必要转换
            return "";
        }
        // 用下划线将原始字符串分割
        String [] camels = name.split(ConstVal.UNDERLINE);
        if(camels.length==1){
        	for(int i=0;i<name.length();i++){
        		char c=name.charAt(i);
        		if(Character.isUpperCase(c)){
        			return  name.substring(0, i);
        		}
        	}
        	return "";
        }else{
        	return camels[0].toLowerCase();
        }
    }
    /**
     * 去掉指定的前缀
     *
     * @param name
     * @param prefix
     * @return
     */
    public static String removePrefix(String name, String  prefix) {
        if (isEmpty(name)) {
            return "";
        }
        if (null != prefix) {
            
                if (name.toLowerCase().startsWith(prefix)) {
                    name=name.substring(prefix.length());
                    if(name.startsWith(ConstVal.UNDERLINE)){
                    	name=name.substring(1);
                    }
                    return name;
                }
        }
        return name;
    }

    /**
     * 去掉下划线前缀且将后半部分转成驼峰格式
     *
     * @param name
     * @param tablePrefix
     * @return
     */
    public static String removePrefixAndCamel(String name, String tablePrefix) {
        return underlineToCamel(removePrefix(name, tablePrefix));
    }

    /**
     * 实体首字母大写
     *
     * @param name 待转换的字符串
     * @return 转换后的字符串
     */
    public static String capitalFirst(String name) {
        if (isNotEmpty(name)) {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        return "";
    }

	public static boolean isEmpty(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * 判断字符串是否不为空
	 * </p>
	 *
	 * @param cs 需要判断字符串
	 * @return 判断结果
	 */
	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}
	
	public static void main(String[] args) {
		System.out.println(NamingStrategy.getMoudule("aaaa"));
		System.out.println(NamingStrategy.getMoudule("aa_bb_ccc"));
		System.out.println(NamingStrategy.getMoudule("Aa_bb_cc"));
		System.out.println(NamingStrategy.getMoudule("abcDef"));
		
		System.out.println(NamingStrategy.removePrefix("Aabbb", "aa"));
		System.out.println(NamingStrategy.removePrefix("Aa_bbb", "aa"));
		
		System.out.println(NamingStrategy.removePrefixAndCamel("Aabbb", "aa"));
		System.out.println(NamingStrategy.removePrefixAndCamel("Aa_bbb", "aa"));
		System.out.println(NamingStrategy.removePrefixAndCamel("Aa_bbb_ccc", "aa"));
		System.out.println(NamingStrategy.removePrefixAndCamel("Aa_bbb_Dc", "aa"));
		
	}
}
