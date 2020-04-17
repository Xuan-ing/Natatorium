package dao;

import entity.card.Card;
import entity.record.Record;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class RecordDAO {
    public void add(Record record) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(record);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void delete(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Record record = session.get(Record.class, id);
        session.delete(record);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public List<Record> listRecords(Card card) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Record> query = session.createQuery("from entity.record.Record record where record.card=:card").setInteger("card", card.getId());
        List<Record> result = query.list();

        session.close();
        sessionFactory.close();
        return result;
    }
}
