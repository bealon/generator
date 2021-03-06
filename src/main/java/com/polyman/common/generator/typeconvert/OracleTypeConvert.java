
package com.polyman.common.generator.typeconvert;

import org.springframework.stereotype.Service;

import com.polyman.common.generator.enums.DbColumnType;

@Service
public class OracleTypeConvert implements TypeConvert {

    @Override
    public DbColumnType processTypeConvert(String fieldType) {
        String t = fieldType.toUpperCase();
        if (t.contains("CHAR")) {
            return DbColumnType.STRING;
        } else if (t.contains("DATE") || t.contains("TIMESTAMP")) {
            return DbColumnType.DATE;
        } else if (t.contains("NUMBER")) {
            if (t.matches("NUMBER\\(+\\d\\)")) {
                return DbColumnType.INTEGER;
            } else if (t.matches("NUMBER\\(+\\d{2}+\\)")) {
                return DbColumnType.LONG;
            }
            return DbColumnType.DOUBLE;
        } else if (t.contains("FLOAT")) {
            return DbColumnType.FLOAT;
        } else if (t.contains("clob")) {
            return DbColumnType.CLOB;
        } else if (t.contains("BLOB")) {
            return DbColumnType.OBJECT;
        } else if (t.contains("binary")) {
            return DbColumnType.BYTE_ARRAY;
        } else if (t.contains("RAW")) {
            return DbColumnType.BYTE_ARRAY;
        }
        return DbColumnType.STRING;
    }

}
