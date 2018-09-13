package aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibDynamicProxy implements MethodInterceptor{

    private  static CGLibDynamicProxy instance = new CGLibDynamicProxy();

    private CGLibDynamicProxy(){}

    public static CGLibDynamicProxy getInstance(){
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls,this);
    }


    public Object intercept(Object target, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(target,params);
        after();
        return result;
    }

    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }


}
