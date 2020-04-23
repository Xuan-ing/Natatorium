package action;

import dao.CardDAO;
import entity.VipUser;
import entity.card.DiscountCard;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DiscountCardAction extends SuperAction  {
    private static final long serialVersionUID = 1L;
    private DiscountCard discountCard = new DiscountCard();

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    public String addDiscountCard() {
        CardDAO cardDAO = new CardDAO();
        DiscountCard newDiscountCard = new DiscountCard();
        newDiscountCard.setType("discountCard");
        newDiscountCard.setVipUser((VipUser) session.getAttribute("curVipUser"));
        newDiscountCard.setAvailability(true);
        newDiscountCard.setDiscountRate(0.8);
        Calendar calendar=new GregorianCalendar();
        calendar.add(Calendar.DATE, 30);
        java.sql.Date date = new Date(calendar.getTimeInMillis());
        newDiscountCard.setDueDate(date);
        cardDAO.addDiscountCard(newDiscountCard);
        return "addDiscountCard";
    }

    public String selectDiscountCard() {
        CardDAO cardDAO = new CardDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        DiscountCard curDiscountCard = cardDAO.getDiscountCard(id);
        session.setAttribute("curDiscountCard",curDiscountCard);
        return "selectDiscountCard";
    }
    public String outOfDate() {
        CardDAO cardDAO = new CardDAO();
        DiscountCard curDiscountCard = (DiscountCard) session.getAttribute("curDiscountCard") ;
        cardDAO.updateDiscountCard(curDiscountCard.getId());
        return "outOfDate";
    }

}
