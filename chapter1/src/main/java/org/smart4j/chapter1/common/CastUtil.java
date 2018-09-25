package org.smart4j.chapter1.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName CastUtil
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 22:08
 * @Version 1.0
 */
public class CastUtil {

    public static String castString(Object obj){
        return CastUtil.castString(obj, "");
    }

    public static String castString(Object obj, String defaultValue){
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static double castDouble(Object obj){
        return CastUtil.castDouble(obj, 0);
    }

    public static double castDouble(Object obj, double defaultValue){
        double doubleValue = defaultValue;
        if (obj != null){
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    
                }

            }
        }
        return
    }
}
