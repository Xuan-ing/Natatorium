import dao.CardDAO;
import dao.VipUserDAO;
import entity.VipUser;
import entity.card.Card;
import entity.card.DiscountCard;
import entity.card.PrepaidCard;
import entity.record.EventRecord;
import entity.record.UsageRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CardDAO cardDAO = new CardDAO();
        VipUserDAO vipUserDAO = new VipUserDAO();
        VipUser vipUser = vipUserDAO.get(4);
        Date date = new Date(2010,10,23);


        PrepaidCard prepaidCard = new PrepaidCard();
        prepaidCard.setType("prepaidCard");
        prepaidCard.setVipUser(vipUser);
        prepaidCard.setAvailability(true);
        prepaidCard.setBalance(500.00);
        cardDAO.addPrepaidCard(prepaidCard);
        transaction.commit();
        session.close();

    }
}
