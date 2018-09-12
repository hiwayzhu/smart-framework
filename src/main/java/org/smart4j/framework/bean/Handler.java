package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * 用于封装action信息
 */
public class Handler {

    /**
     * Action方法
     */
    private Method actionMethod;
    /**
     * controller类
     */
    private Class<?> controllerClass;

    public Handler(Class<?> controllerClass,Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }
}
