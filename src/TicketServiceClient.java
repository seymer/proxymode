public class TicketServiceClient {
    public static void main(String[] argv) throws Exception {
        /*
         * 可以直接去售票站买票，但我们图省事，想就近在代理售票点买票
         */
        TicketStationProxy tsp = new TicketStationProxy(new TicketStation());
        /*
         * 调用票务服务接口的售票功能
         */
        tsp.SellTicket();
        /*
         * 调用票务服务接口的咨询功能，出事了，过年不能回湖南了，我想退票
         */
        tsp.ConsultTicket();
        /*
         * 调用票务服务接口的退票功能
         */
        tsp.ReturnTicket();
    }
}
