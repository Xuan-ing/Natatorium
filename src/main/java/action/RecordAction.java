package action;

import dao.RecordDAO;
import entity.record.Record;

import java.util.List;

public class RecordAction {
    private Record record;
    private RecordDAO recordDAO;
    private List<Record> recordList;

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
     * @return
     */
    public String addUserEvent() {
        recordDAO.add(record);
        return "cardManager";
    }
    public String addAdminEvent() {
        recordDAO.add(record);
        return "adminCardManager";
    }
    public String addConsumeEvent() {
        recordDAO.add(record);
        return "consume";
    }
}
