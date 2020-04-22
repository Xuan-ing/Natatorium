package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(vipUser);
        transaction.commit();
    }

    /**
     *
     * @param id ID segment in VipUser table.
     * @return The selected user object.
     */
    public VipUser get(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        VipUser curVipUser = session.get(VipUser.class, id);
        transaction.commit();
        return curVipUser;
    }

    /**
     *
     * @param vipUser The original user object to be updated.
     */
    public void update(VipUser vipUser) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(vipUser);
        transaction.commit();
    }

    public void delete(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from entity.VipUser user where user.id=:id")
                .setParameter("id",id);
        VipUser vipUser = (VipUser) query.uniqueResult();
        session.delete(vipUser);
        transaction.commit();
    }
    /**
     *
     * @return All exist users stored as a list.
     */
    public List<VipUser> listUsers() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from entity.VipUser user");
        List<VipUser> result =(List<VipUser>) query.list();
        transaction.commit();
        return result;
    }

    /**
     * TEST PASSED 9 Apr 2020
     * @param tel
     */
    public VipUser select(String tel) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from entity.VipUser user where user.tel=:tel")
                .setParameter("tel", tel);
        if(query.list().size() == 0){
            return null;
        }
        VipUser result = (VipUser) query.uniqueResult();
        transaction.commit();
        return result;
    }
}
