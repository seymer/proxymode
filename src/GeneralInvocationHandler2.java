/*
 * javac -encoding GBK -g GeneralInvocationHandler2.java
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GeneralInvocationHandler2 implements InvocationHandler {
    private Object realobj;

    /**
     * 实现bind()，简化编程，参看TicketServiceClient2.java。函数名任意。
     */
    public Object bind(Object realobj) {
        this.realobj = realobj;
        Object obj = Proxy.newProxyInstance
                (
                        realobj.getClass().getClassLoader(),
                        /*
                         * https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html
                         *
                         * 返回"Class<?>[]"
                         */
                        realobj.getClass().getInterfaces(),
                        this
                );
        return (obj);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*
         * 转发至目标对象
         */
        Object obj = method.invoke(realobj, args);
        return (obj);
    }
}