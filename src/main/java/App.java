import dao.VipUserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pojo.VipUser;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        VipUserDAO vipUserDAO = new VipUserDAO();
        VipUser vipUser = new VipUser();
        vipUser.setName("xuan");
        vipUser.setNo("123123123");
        vipUser.setPassword("12313123123");
        vipUser.setTel("12313");
        session.persist(vipUser);
        transaction.commit();
        session.close();
    }
}
