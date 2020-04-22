import dao.CardDAO;
import dao.RecordDAO;
import entity.card.Card;
import entity.record.UsageRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CardDAO cardDAO = new CardDAO();
        Card card = cardDAO.get(1);
        RecordDAO recordDAO = new RecordDAO();
        UsageRecord usageRecord = new UsageRecord();
        usageRecord.setPrice(100.0);
        usageRecord.setCard(card);
        recordDAO.add(usageRecord);
        transaction.commit();
        session.close();

    }
}
