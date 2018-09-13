package org.smart4j.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 代理管理器
 */
public class ProxyManager {

    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList){
        //create方法返回值是targetClass的一个实例的代理
        //Object create(Class[], Object[]) 使用有参数的构造函数创建目标对象。参数Class[] 定义了参数的类型，第二个Object[]是参数的值
//        public Object intercept(Object object, java.lang.reflect.Method method, Object[] args, MethodProxy proxy) throws Throwable;
//        参数Object object是被代理对象，不会出现死循环的问题。
//        参数java.lang.reflect.Method method是java.lang.reflect.Method类型的被拦截方法。
//        参数Object[] args是被被拦截方法的参数。
//        参数MethodProxy proxy是CGLIB提供的MethodProxy 类型的被拦截方法。
        return (T) Enhancer.create(targetClass, new MethodInterceptor() {
            public Object intercept(Object targetObject, Method targetMethod, Object[] methodParams, MethodProxy methodProxy) throws Throwable {
                return new ProxyChain(targetClass,targetObject,targetMethod,methodProxy,methodParams,proxyList).doProxyChain();
            }
        });
    }
}
