/*
 * javac -encoding GBK -g TicketServiceClient2.java
 * java TicketServiceClient2
 */

public class TicketServiceClient2 {
    public static void main(String[] argv) throws Exception {
        GeneralInvocationHandler2 gih = new GeneralInvocationHandler2();
        /*
         * GeneralInvocationHandler2实现bind()，简化编程
         */
        TicketService ts = (TicketService) gih.bind(new TicketStation());
        ts.SellTicket();
        ts.ConsultTicket();
        ts.ReturnTicket();
    }
}