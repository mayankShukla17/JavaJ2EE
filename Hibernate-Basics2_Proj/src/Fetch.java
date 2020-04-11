import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Fetch 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		System.out.println("Configuraton Done");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println("Factory Done");

		Session session = sessionFactory.openSession();

		Human human = session.get(Human.class, new Integer(2));
		System.out.println(human);
		
		//1st resource
		session.close();

		//2nd
		sessionFactory.close();
	}
}
