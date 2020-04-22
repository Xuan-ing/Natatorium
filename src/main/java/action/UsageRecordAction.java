package action;

import dao.RecordDAO;
import entity.card.Card;
import entity.record.UsageRecord;

import java.util.ArrayList;
import java.util.List;

public class UsageRecordAction extends SuperAction {

    @Override
    public String execute() throws Exception {
        List<Card> cardList =(List<Card>) session.getAttribute("cardList");
        System.out.println("卡：" + cardList.size());
        List<UsageRecord> usageRecords = new ArrayList<>();
        for(int i=0;i<cardList.size();++i) {
            List<UsageRecord> usageRecordList = new RecordDAO().listUsageRecords(cardList.get(i));
            usageRecords.addAll(usageRecordList);
        }
        System.out.println("记录：" + usageRecords.size());
        session.setAttribute("usageRecords", usageRecords);
        return SUCCESS;
    }
}
