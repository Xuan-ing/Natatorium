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
        DiscountCard discountCard = (DiscountCard) session.get(DiscountCard.class,id);
        transaction.commit();
        return discountCard;
    }
    public void updateDiscountCard(DiscountCard discountCard) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.merge(discountCard);
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
        PrepaidCard prepaidCard = (PrepaidCard) session.get(PrepaidCard.class,id);
        transaction.commit();
        return prepaidCard;
    }
    public void updatePrepaidCard(PrepaidCard prepaidCard) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.merge(prepaidCard);
        transaction.commit();
    }

    /**
     *
     * @param id ID segment in Card table.
     * @return The selected card object.
     */
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
        //System.out.println(curUser.getName());
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        //System.out.println(curUser.getTel());
        Query query = session.createQuery("from entity.card.Card card where card.vipUser.id=:id").setParameter("id", curUser.getId());
        List<Card> result = query.list();
        //System.out.println(result.get(0).getAvailability());
        session.close();
        sessionFactory.close();
        return result;
    }
}
