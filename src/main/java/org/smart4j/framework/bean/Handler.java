package org.smart4j.framework.bean;

import java.lang.reflect.Method;

public class Handler {

    private Method actionMethod;
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
