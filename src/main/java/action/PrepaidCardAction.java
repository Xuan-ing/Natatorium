package action;

import dao.CardDAO;
import entity.VipUser;
import entity.card.Card;
import entity.card.PrepaidCard;

import java.util.List;

public class PrepaidCardAction extends SuperAction  {
    private static final long serialVersionUID = 1L;
    private PrepaidCard prepaidCard = new PrepaidCard();

    public PrepaidCard getPrepaidCard() {
        return prepaidCard;
    }
    public void setPrepaidCard(PrepaidCard prepaidCard) {
        this.prepaidCard = prepaidCard;
    }

    public String addPrepaidCard() {
        CardDAO cardDAO = new CardDAO();
        PrepaidCard curPrepaidCard = new PrepaidCard();
        curPrepaidCard.setAvailability(true);
        curPrepaidCard.setVipUser((VipUser)session.getAttribute("curVipUser"));
        curPrepaidCard.setType("prepaidCard");
        curPrepaidCard.setBalance(500.0);
        cardDAO.addPrepaidCard(curPrepaidCard);
        return "addPrepaidCard";
    }

    public String selectPrepaidCard() {
        CardDAO cardDAO = new CardDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        PrepaidCard curPrepaidCard = cardDAO.getPrepaidCard(id);
        session.setAttribute("curPrepaidCard",curPrepaidCard);
        return "selectPrepaidCard";
    }
    public String reportLoss() {
        CardDAO cardDAO = new CardDAO();
        PrepaidCard curPrepaidCard = (PrepaidCard) session.getAttribute("curPrepaidCard");
        cardDAO.updatePrepaidCardAvailability(curPrepaidCard.getId());//更新数据库
        PrepaidCard newCurPrepaidCard = cardDAO.getPrepaidCard(curPrepaidCard.getId());
        session.setAttribute("curPrepaidCard",newCurPrepaidCard);//跟新session
        return "reportLoss";
    }
    public String consume() {
        CardDAO cardDAO = new CardDAO();
        PrepaidCard curPrepaidCard = (PrepaidCard) session.getAttribute("curPrepaidCard");
        cardDAO.updatePrepaidCardBalance(curPrepaidCard.getId());//更新数据库
        PrepaidCard newCurPrepaidCard = cardDAO.getPrepaidCard(curPrepaidCard.getId());
        session.setAttribute("curPrepaidCard",newCurPrepaidCard);//跟新session
        return "consume";
    }
    public String recharge() {
        CardDAO cardDAO = new CardDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        cardDAO.recharge(id);//更新数据库
        return "recharge";
    }

    public String getPrepaidCards() {
        VipUser curVipUser = (VipUser) session.getAttribute("curVipUser");
        if(curVipUser != null) {
            CardDAO cardDAO = new CardDAO();
            List<PrepaidCard> prepaidCardList = cardDAO.listPrepaidCard(curVipUser);
            //System.out.println("读取该用户：" + prepaidCardList.size() + "张卡");
            session.setAttribute("prepaidCardList", prepaidCardList);//cards放进session,多次运行最新的会覆盖以前的
        }
        return "getPrepaidCards";
    }

}
