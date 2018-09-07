package org.smart4j.framework.util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 属性文件工具类
 */
public class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);


    /**
     * 加载属性文件
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName){
        Properties props = null;
        InputStream is =null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null){
                throw  new FileNotFoundException(fileName+"file is not found");
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try{
                    is.close();
                }catch (IOException e){
                    LOGGER.error("close input stream failure",e);
                }
            }
        }
        return props;
    }

    public static String getString(Properties  props,String key){
        return getString(props,key,"");
    }

    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if(props.containsKey(key)){
            value = props.getProperty(key);
        }
        return  value;
    }

    public static int getInt(Properties props,String key){
        return getInt(props,key,0);
    }

    private static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if(props.containsKey(key)){
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    public static boolean getBoolean(Properties props,String key){
        return getBoolean(props,key,false);
    }

    private static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if(props.containsKey(key)){
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }


}
