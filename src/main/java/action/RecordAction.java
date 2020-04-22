package action;

import com.opensymphony.xwork2.ActionContext;
import dao.RecordDAO;
import dao.VipUserDAO;
import entity.VipUser;
import entity.card.Card;
import entity.record.EventRecord;
import entity.record.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordAction extends SuperAction {
    private Record record = new Record();
    private RecordDAO recordDAO = new RecordDAO();
    private List<Record> recordList = new ArrayList<>();

    public void setRecord(Record record) {
        this.record = record;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecordDAO(RecordDAO recordDAO) {
        this.recordDAO = recordDAO;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    public RecordDAO getRecordDAO() {
        return recordDAO;
    }

    /**
     * 用于区分不同页面，实际都是添加了事件
     *
     * @return
     */
    public String addUserEvent() {
        recordDAO.add(record);
        return "cardManagement";
    }

    public String addAdminEvent() {
        recordDAO.add(record);
        return "adminCardManagement";
    }

    public String addConsumptionEvent() {
        recordDAO.add(record);
        return "consumption";
    }

    public String queryRecordsByUser() {
        List<Card> cards = (List<Card>) session.getAttribute("cards");
        List<Record> allRecordsOfCards = new ArrayList<>();
        for (Card card : cards) {
            List<Record> records = recordDAO.listRecords(card);
            allRecordsOfCards.addAll(records);
        }
        session.setAttribute("allUserRecords", allRecordsOfCards);
        return "queryRecordsByUser";
    }

    public String queryRecordsByCard() {
        List<Record> records = recordDAO.listRecords(record.getCard());
        session.setAttribute("allCardRecords", records);
        return "queryRecordsByCard";
    }
}
