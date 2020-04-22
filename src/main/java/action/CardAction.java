package action;

import dao.CardDAO;
import entity.VipUser;
import entity.card.Card;

import java.util.List;

public class CardAction extends SuperAction {
    private Card card = new Card();

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public String deleteCard() {
        CardDAO cardDAO = new CardDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        cardDAO.delete(id);
        return "deleteDCard";
    }

    /**
     * 传入session里的当前用户，查找拥有的卡，并存入session中
     *
     */
    public String getCards() {
        session.removeAttribute("cards");
        VipUser curVipUser = (VipUser) session.getAttribute("curVipUser");
        CardDAO cardDAO =new  CardDAO();
        List<Card> cards = cardDAO.listCards(curVipUser);
        session.setAttribute("cards", cards);//cards放进session
        return "getCards";
    }
}
