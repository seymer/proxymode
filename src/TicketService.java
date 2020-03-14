/**
 * javac -encoding GBK -g TicketService.java
 *
 * 票务服务接口
 */
public interface TicketService {
    void SellTicket();     // 出售

    void ConsultTicket();  // 咨询

    void ReturnTicket();   // 退票
}