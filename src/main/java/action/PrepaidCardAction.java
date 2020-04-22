package action;

import dao.CardDAO;
import entity.VipUser;
import entity.card.PrepaidCard;
import entity.card.PrepaidCard;

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
    public String updatePrepaidCard() {
        CardDAO cardDAO = new CardDAO();
        cardDAO.updatePrepaidCard(prepaidCard);
        return "updatePrepaidCard";
    }

}
