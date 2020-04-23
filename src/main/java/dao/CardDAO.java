package dao;

import entity.VipUser;
import entity.card.Card;
import entity.card.DiscountCard;
import entity.card.PrepaidCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author Xuan.170910224
 * @version v1.0.0
 * @since 6 Apr 2020
 */
public class CardDAO {

    public void addDiscountCard(DiscountCard discountCard) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(discountCard);
        transaction.commit();

    }
    public DiscountCard getDiscountCard(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        DiscountCard discountCard = session.get(DiscountCard.class,id);
        transaction.commit();
        return discountCard;
    }
    /*
    折扣卡过期
     */
    public void updateDiscountCard(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        DiscountCard discountCard = session.get(DiscountCard.class,id);
        discountCard.setAvailability(false);
        transaction.commit();
    }
    public void addPrepaidCard(PrepaidCard prepaidCard) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(prepaidCard);
        transaction.commit();
    }
    public PrepaidCard getPrepaidCard(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        PrepaidCard prepaidCard = session.get(PrepaidCard.class,id);
        transaction.commit();
        return prepaidCard;
    }
    /*
    消费
     */
    public void updatePrepaidCardAvailability(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        PrepaidCard prepaidCard = session.get(PrepaidCard.class,id);
        prepaidCard.setAvailability(false);
        transaction.commit();
    }
    /*
    挂失
     */
    public void updatePrepaidCardBalance(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        PrepaidCard prepaidCard = session.get(PrepaidCard.class,id);
        double balance = prepaidCard.getBalance();
        if(balance > 60)
            prepaidCard.setBalance(balance-60);
        transaction.commit();
    }

    public void recharge(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        PrepaidCard prepaidCard = session.get(PrepaidCard.class,id);
        double balance = prepaidCard.getBalance();
        prepaidCard.setBalance(balance+100);
        transaction.commit();
    }
    public List<PrepaidCard> listPrepaidCard(VipUser user) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from entity.card.PrepaidCard card where card.vipUser.id=:id").setParameter("id", user.getId());
        List<PrepaidCard> result = query.list();
        session.close();
        sessionFactory.close();
        return result;
    }

    public Card get(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Card card = session.get(Card.class, id);
        session.close();
        sessionFactory.close();
        return card;
    }

    public void delete(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Card card= session.get(Card.class, id);
        session.delete(card);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    public List<Card> listCards(VipUser curUser) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from entity.card.Card card where card.vipUser.id=:id").setParameter("id", curUser.getId());
        List<Card> result = query.list();
        session.close();
        sessionFactory.close();
        return result;
    }
}
