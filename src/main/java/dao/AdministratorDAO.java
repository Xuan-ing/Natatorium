package dao;

import entity.VipUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import entity.Administrator;

import java.util.List;

public class AdministratorDAO {
    /**
     *
     * @param administrator A user object to be inserted
     */
    public void add(Administrator administrator) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(administrator);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    /**
     *
     * @param id ID segment in Administrator table.
     * @return The selected admin object.
     */
    public Administrator get(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Administrator administrator = session.get(Administrator.class, id);
        session.close();
        sessionFactory.close();
        return administrator;
    }

    /**
     *
     * @param administrator The original object to be updated.
     */
    public void update(Administrator administrator) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(administrator);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    /**
     *
     * @return All exist admins stored as a list.
     */
    public List<Administrator> listProduct() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Administrator> query = session.createQuery("from Administrator administrator");
        List<Administrator> result = query.list();

        session.close();
        sessionFactory.close();
        return result;
    }

    public Administrator select(String username) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from entity.Administrator admin where admin.username=:username")
                .setParameter("username", username);
        if(query.list().size() == 0){
            return null;
        }
        Administrator administrator = (Administrator) query.uniqueResult();
        transaction.commit();
        return administrator;
    }
}
