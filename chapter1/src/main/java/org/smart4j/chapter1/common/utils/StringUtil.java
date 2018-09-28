package org.smart4j.chapter1.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName StringUtil
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/27 21:57
 * @Version 1.0
 */
public class StringUtil {

    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
