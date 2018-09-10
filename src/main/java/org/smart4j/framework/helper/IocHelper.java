package org.smart4j.framework.helper;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public final class IocHelper {

    static {
        //获取所有的Bean类与Bean实例之间的映射关系（简称Bean Map）
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtils.isNotEmpty((Collection<?>) beanMap)){
            //遍历Bean Map
            for(Map.Entry<Class<?>,Object> beanEntity:beanMap.entrySet()){
                //从BeanMap中获取Bean类和Bean实例
                Class<?> beanClass = beanEntity.getKey();
                Object beanInstance = beanEntity.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(beanFields)){
                    //遍历Bean Field
                    for(Field beanField:beanFields){
                        if(beanField.isAnnotationPresent(Inject.class)){
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanField!=null){
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
