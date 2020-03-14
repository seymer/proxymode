/*
 * javac -encoding GBK -g TicketStationProxy.java
 */

/**
 * 代理售票点，可以就近代替售票站提供便民服务。必须与售票站一样，实现票务
 * 服务接口，但有些活儿可以不自己干，转发。
 */
public class TicketStationProxy implements TicketService {
    private TicketStation ts;

    public TicketStationProxy(TicketStation ts) {
        this.ts = ts;
    }

    @Override
    public void SellTicket() {
        /*
         * 代理售票点在代理销售过程中可以提供额外服务、收取额外费用，通过
         * before()、after()体现
         */
        before("TicketStationProxy.SellTicket()");
        /*
         * 代理售票点转发服务请求至售票站，不需要事必躬亲，但可以自己做，
         * 比如销售假票、一票多售等等
         */
        ts.SellTicket();
        after("TicketStationProxy.SellTicket()");
    }

    @Override
    public void ConsultTicket() {
        before("TicketStationProxy.ConsultTicket()");
        ts.ConsultTicket();
        after("TicketStationProxy.ConsultTicket()");
    }

    @Override
    public void ReturnTicket() {
        before("TicketStationProxy.ReturnTicket()");
        ts.ReturnTicket();
        after("TicketStationProxy.ReturnTicket()");
    }

    private void before(String s) {
        System.out.println("Before " + s);
    }

    private void after(String s) {
        System.out.println("After " + s);
    }
}