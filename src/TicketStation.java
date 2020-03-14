/*
 * javac -encoding GBK -g TicketStation.java
 */

/**
 * 售票站，具体实现票务服务接口，提供具体业务逻辑
 */
public class TicketStation implements TicketService {
    @Override
    public void SellTicket() {
        System.out.println("TicketStation.SellTicket()");
    }

    @Override
    public void ConsultTicket() {
        System.out.println("TicketStation.ConsultTicket()");
    }

    @Override
    public void ReturnTicket() {
        System.out.println("TicketStation.ReturnTicket()");
    }

}
