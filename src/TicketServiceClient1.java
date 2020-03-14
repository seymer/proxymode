/*
 * javac -encoding GBK -g TicketServiceClient1.java
 * java TicketServiceClient1
 */

import java.lang.reflect.Proxy;

public class TicketServiceClient1 {
    public static void main(String[] argv) throws Exception {
        GeneralInvocationHandler gih = new GeneralInvocationHandler(new TicketStation());
        /*
         * https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html
         *
         * Java与C不同，后者续行用反斜杠(\)，Java不需要额外的续行符，直接
         * 折行即可。
         */
        TicketService ts =
                (TicketService) Proxy.newProxyInstance
                        (
                                TicketService.class.getClassLoader(),
                                new Class[]{TicketService.class},
                                gih
                        );
        /*
         * 另一种方式得到ts，写法复杂
         */
        // ( TicketService )Proxy.
        // getProxyClass( TicketService.class.getClassLoader(), TicketService.class ).
        // getConstructor( InvocationHandler.class ).
        // newInstance( gih );
        /*
         * 就本例而言，会去调用TicketStation.SellTicket()
         */
        ts.SellTicket();
        ts.ConsultTicket();
        ts.ReturnTicket();
    }
}