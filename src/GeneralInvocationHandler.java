/*
 * javac -encoding GBK -g GeneralInvocationHandler.java
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/InvocationHandler.html
 *
 * InvocationHandler is the interface implemented by the invocation
 * handler of a proxy instance. Each proxy instance has an associated
 * invocation handler. When a method is invoked on a proxy instance, the
 * method invocation is encoded and dispatched to the invoke method of its
 * invocation handler.
 */
public class GeneralInvocationHandler implements InvocationHandler {
    private Object realobj;

    public GeneralInvocationHandler(Object realobj) {
        this.realobj = realobj;
    }

    /**
     * This method will be invoked on an invocation handler when a method
     * is invoked on a proxy instance that it is associated with.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*
         * 转发至目标对象
         */
        Object obj = method.invoke(realobj, args);
        return (obj);
    }
}