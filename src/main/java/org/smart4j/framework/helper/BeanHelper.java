package org.smart4j.framework.helper;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;
import org.smart4j.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class BeanHelper {

    /**
     * 定义Bean映射（用于存放Bean类和Bean实例的映射关系）
     */
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for(Class<?> cls:beanClassSet){
            Object obj = ReflectionUtil.newInstance(cls);
            BEAN_MAP.put(cls,obj);
        }
    }

    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cls){
        if(!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean by class:"+cls);
        }
        return (T)BEAN_MAP.get(cls);
    }

    public static void setBean(Class<?> cls,Object obj){
        BEAN_MAP.put(cls,obj);
    }

}
