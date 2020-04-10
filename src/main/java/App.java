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
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

         // ADD A NEW USER
//        VipUser vipUser = new VipUser();
//        vipUser.setName("xuan");
//        vipUser.setNo("12321342");
//        vipUser.setPassword("!31231");
//        vipUser.setTel("123123");
//        session.save(vipUser);

//        VipUserDAO vipUserDAO = new VipUserDAO();
//        VipUser vipUser = vipUserDAO.get(1);
//        DiscountCard card = new DiscountCard();
//        card.setAvailability(true);
//        card.setType("discount_card");
//        card.setVipUser(vipUser);
//        card.setDiscountRate(0.9);
//        card.setDueDate(new Date(new java.util.Date().getTime()));
//        session.save(card);
        CardDAO cardDAO = new CardDAO();
        Card card = cardDAO.get(2);
        EventRecord record = new EventRecord();
        record.setCard(card);
        record.setDate(new Date(new java.util.Date().getTime()));
        record.setEventType("xxx");
        record.setReason("setdrcygvbhj");
        record.setType("usage_record");
        session.save(record);

        transaction.commit();
        session.close();

    }
}
