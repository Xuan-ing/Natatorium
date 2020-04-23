package action;

import dao.RecordDAO;
import entity.card.Card;
import entity.card.PrepaidCard;
import entity.record.EventRecord;
import entity.record.Record;
import entity.record.UsageRecord;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class RecordAction extends SuperAction {
    private Record record = new Record();

    public void setRecord(Record record) {
        this.record = record;
    }

    public Record getRecord() {
        return record;
    }


    /**
     * 用于区分不同页面，实际都是添加了事件
     *
     *
     */
    public String addConsumeEvent() {
        RecordDAO recordDAO = new RecordDAO();
        UsageRecord newUsageRecord = new UsageRecord();
        PrepaidCard curPrepaidCard = (PrepaidCard) session.getAttribute("curPrepaidCard") ;
        newUsageRecord.setCard(curPrepaidCard);
        newUsageRecord.setPrice(-60.0);
        Calendar calendar=new GregorianCalendar();
        Date date = new Date(calendar.getTimeInMillis());
        newUsageRecord.setDate(date);
        newUsageRecord.setType("usageRecord");
        recordDAO.add(newUsageRecord);
        return "addConsumeEvent";
    }
    public String addRechargeEvent() {
        RecordDAO recordDAO = new RecordDAO();
        UsageRecord newUsageRecord = new UsageRecord();
        PrepaidCard curPrepaidCard = (PrepaidCard) session.getAttribute("curPrepaidCard") ;
        newUsageRecord.setCard(curPrepaidCard);
        newUsageRecord.setPrice(100.0);
        Calendar calendar=new GregorianCalendar();
        Date date = new Date(calendar.getTimeInMillis());
        newUsageRecord.setDate(date);
        newUsageRecord.setType("usageRecord");
        recordDAO.add(newUsageRecord);
        return "addRechargeEvent";
    }

    public String addLossEvent() {
        RecordDAO recordDAO = new RecordDAO();
        EventRecord newEventRecord = new EventRecord();
        PrepaidCard curPrepaidCard = (PrepaidCard) session.getAttribute("curPrepaidCard") ;
        newEventRecord.setCard(curPrepaidCard);
        newEventRecord.setType("eventRecord");
        newEventRecord.setEventType("reportLoss");
        Calendar calendar=new GregorianCalendar();
        Date date = new Date(calendar.getTimeInMillis());
        newEventRecord.setDate(date);
        recordDAO.add(newEventRecord);
        return "addLossEvent";
    }
    public String addCancelLossEvent() {
        RecordDAO recordDAO = new RecordDAO();
        EventRecord newEventRecord = new EventRecord();
        PrepaidCard curPrepaidCard = (PrepaidCard) session.getAttribute("curPrepaidCard") ;
        newEventRecord.setCard(curPrepaidCard);
        newEventRecord.setType("eventRecord");
        newEventRecord.setEventType("cancelLoss");
        Calendar calendar=new GregorianCalendar();
        Date date = new Date(calendar.getTimeInMillis());
        newEventRecord.setDate(date);
        recordDAO.add(newEventRecord);
        return "addCancelLossEvent";
    }


    public String queryRecordsByUser() {
        List<Card> cards = (List<Card>) session.getAttribute("cards");
        List<Record> allRecordsOfCards = new ArrayList<>();
        RecordDAO recordDAO = new RecordDAO();
        for (Card card : cards) {
            List<Record> records = recordDAO.listRecords(card);
            allRecordsOfCards.addAll(records);
        }
        session.setAttribute("allUserRecords", allRecordsOfCards);
        return "queryRecordsByUser";
    }

    public String queryRecordsByCard() {
        RecordDAO recordDAO = new RecordDAO();
        List<Record> records = recordDAO.listRecords(record.getCard());
        session.setAttribute("allCardRecords", records);
        return "queryRecordsByCard";
    }


}
