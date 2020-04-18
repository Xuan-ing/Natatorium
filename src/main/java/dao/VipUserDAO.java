package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import entity.VipUser;

import java.util.List;

/**
 * @author Xuan.170910224
 * @version v1.0.0
 * @since 5 Apr 2020
 */
public class VipUserDAO {
    /**
     *
     * @param vipUser A user object to be inserted
     */
    public void add(VipUser vipUser) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(vipUser);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    /**
     *
     * @param id ID segment in VipUser table.
     * @return The selected user object.
     */
    public VipUser get(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        VipUser vipUser = session.get(VipUser.class, id);
        session.close();
        sessionFactory.close();
        return vipUser;
    }

    /**
     *
     * @param vipUser The original user object to be updated.
     */
    public void update(VipUser vipUser) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(vipUser);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void delete(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        VipUser vipUser = session.get(VipUser.class, id);
        session.delete(vipUser);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    /**
     *
     * @return All exist users stored as a list.
     */
    public List<VipUser> listUsers() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<VipUser> query = session.createQuery("from entity.VipUser user");
        List<VipUser> result = query.list();

        session.close();
        sessionFactory.close();
        return result;
    }

    /**
     * TEST PASSED 9 Apr 2020
     * @param tel
     * @param password
     */
    public VipUser select(String tel) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<VipUser> query = session.createQuery("from entity.VipUser user where user.tel=:tel")
                .setString("tel", tel);
        List<VipUser> result = query.list();

        session.close();
        sessionFactory.close();
        return result.get(0);
    }
}
