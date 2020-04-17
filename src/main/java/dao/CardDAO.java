package dao;

import entity.record.Record;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import entity.card.Card;
import entity.VipUser;

import javax.crypto.spec.RC2ParameterSpec;
import java.util.List;

/**
 * @author Xuan.170910224
 * @version v1.0.0
 * @since 6 Apr 2020
 */
public class CardDAO {
    /**
     *
     * @param card A user's card, either prepaid_card or discount_card.
     */
    public void add(Card card) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(card);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
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

    /**
     *
     * @param card The original card object to be updated.
     */
    public void update(Card card) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(card);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public List<Card> listCards(VipUser vipUser) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Card> query = session.createQuery("from entity.card.Card card where card.vipUser.id=:id").setInteger("id", vipUser.getId());
        List<Card> result = query.list();

        session.close();
        sessionFactory.close();
        return result;
    }
}
