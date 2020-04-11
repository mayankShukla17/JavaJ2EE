import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Update 
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure();
		System.out.println("Configuration Done");
		
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		System.out.println("Factory Done");
		
		Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		Human shyam=session.get(Human.class,new Integer(3));
		System.out.println(shyam);
		
		shyam.setName("Radha");
		
		session.update(shyam);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
