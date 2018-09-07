package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

public final class CastUtil {

    public static String castString(Object obj){
        return CastUtil.castString(obj,"");
    }

    public  static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static int castInt(Object obj){
        return CastUtil.castInt(obj,0);
    }

    private static int castInt(Object obj, int defalutValue) {
        int intValue = defalutValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNotBlank(strValue)){
                try{
                    intValue = Integer.parseInt(strValue);
                }catch (NumberFormatException e){
                    intValue = defalutValue;
                }
            }
        }
        return intValue;
    }

    public static double castDouble(Object obj){
        return CastUtil.castDouble(obj,0);
    }

    private static double castDouble(Object obj, int defalutValue) {
        double doubleValue = defalutValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNotBlank(strValue)){
                try{
                    doubleValue = Double.parseDouble(strValue);
                }catch (NumberFormatException e){
                    doubleValue = defalutValue;
                }
            }
        }
        return doubleValue;
    }

    public static long castLong(Object obj){
        return CastUtil.castLong(obj,0);
    }

    private static long castLong(Object obj, int defalutValue) {
        long longValue = defalutValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNotBlank(strValue)){
                try{
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    longValue   = defalutValue;
                }
            }
        }
        return longValue;
    }


    public static boolean castBoolean(Object obj){
        return CastUtil.castBoolean(obj,false);
    }

    private static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if(obj !=null){
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }



}
