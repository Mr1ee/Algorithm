package fresh.lee.algorithm.java.design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @param <T> T只能是接口类型 interface
 */
public class DynamicProxy<T> implements InvocationHandler {

    private T mObject;

    /**
     * 生成动态代理对象
     *
     * @param object 被代理对象
     */
    @SuppressWarnings("unchecked")
    public T newProxyInstance(T object) {
        this.mObject = object;
        //获得 ClassLoader
        ClassLoader classLoader = object.getClass().getClassLoader();
        //获得接口数组
        Class<?>[] interfaces = object.getClass().getInterfaces();
        //生成动态代理对象
        return (T) Proxy.newProxyInstance(classLoader, interfaces, this);
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // do something
        System.out.println("我是代理，代理了：" + method.getName() + "方法");
        return method.invoke(this.mObject, objects);
    }
}
