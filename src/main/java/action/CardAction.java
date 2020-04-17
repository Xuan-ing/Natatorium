package action;

import com.opensymphony.xwork2.ActionContext;
import dao.CardDAO;
import dao.RecordDAO;
import entity.VipUser;
import entity.card.Card;
import entity.card.PrepaidCard;

import java.util.List;

public class CardAction {
    public static Double PRICE;

    private Card card;
    private CardDAO cardDAO;
    private List<Card> cards;

    public void setCardDAO(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    public List<Card> getCards() {
        return cards;
    }

    public CardDAO getCardDAO() {
        return cardDAO;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String addCard() {
        cardDAO.add(card);
        return "cardManager";
    }

    public String deleteCard() {
        cardDAO.delete(card.getId());
        return "cardManager";
    }

    /**
     * 挂失卡，并保存到event_record中
     * @return
     */
    public String reportLoss() {
        card.setAvailability(false);
        return "cardManager";
    }

    public String recoverLoss() {
        card.setAvailability(true);
        return "adminCardManager";
    }

    public String recharge() {
        ((PrepaidCard) card).setBalance(((PrepaidCard) card).getBalance() + 100);
        return "success";
    }

    public String consume() {
        if (card.consume()) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 传入session里的当前用户，查找拥有的卡，并存入session中
     * @return
     */
    public String getUserCardList() {
        VipUser curVipUser = (VipUser) ActionContext.getContext().getSession().get("vipUser");
        System.out.println(curVipUser.getName());
        cards = cardDAO.listCards(curVipUser);
        System.out.println(cards.get(0).getId());
        ActionContext.getContext().getSession().put("cards", cards);//cards放进session
        return "getUserCardList";
    }
}
