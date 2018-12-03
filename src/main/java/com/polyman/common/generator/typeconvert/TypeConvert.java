package com.polyman.common.generator.typeconvert;

import com.polyman.common.generator.enums.DbColumnType;

/**
 * <p>
 * 数据库字段类型转换
 * </p>
 */
public interface TypeConvert {

    /**
     * <p>
     * 执行类型转换
     * </p>
     *
     * @param fieldType 字段类型
     * @return
     */
    DbColumnType processTypeConvert(String fieldType);

}
