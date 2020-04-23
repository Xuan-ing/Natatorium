package action;

import dao.RecordDAO;
import entity.VipUser;
import entity.card.Card;
import entity.record.UsageRecord;

import java.util.ArrayList;
import java.util.List;

public class UsageRecordAction extends SuperAction {

    @Override
    public String execute() throws Exception {
        VipUser curVipUser = (VipUser) session.getAttribute("curVipUser");
        List<Card> cardList = (List<Card>) session.getAttribute("cardList");
        if(curVipUser != null) {
            //System.out.println("卡：" + cardList.size());
            List<UsageRecord> usageRecords = new ArrayList<>();
            for (int i = 0; i < cardList.size(); ++i) {
                List<UsageRecord> usageRecordList = new RecordDAO().listUsageRecords(cardList.get(i));
                usageRecords.addAll(usageRecordList);
            }
            System.out.println("记录：" + usageRecords.size());
            session.setAttribute("usageRecords", usageRecords);
        }
        return SUCCESS;
    }
}
