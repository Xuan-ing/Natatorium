package action;

import dao.RecordDAO;
import entity.card.Card;
import entity.card.PrepaidCard;
import entity.record.EventRecord;

import java.util.List;

public class EventRecordAction extends SuperAction {
    private Card card = new Card();

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    /*

     */
    public String execute()  {
        PrepaidCard prepaidCard = (PrepaidCard) session.getAttribute("curPrepaidCard");
        List<EventRecord> eventRecords = new RecordDAO().listEventRecords(card);
        session.setAttribute("eventRecords", eventRecords);
        return "success";
    }
}
