package org.smart4j.framework.bean;

import java.lang.reflect.Method;

public class Handler {

    private Method axtionMethod;
    private Class<?> controllerClass;

    public Handler(Class<?> controllerClass,Method actionMethod){
        this.controllerClass = controllerClass;
        this.axtionMethod = actionMethod;
    }

    public Method getAxtionMethod() {
        return axtionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }
}
