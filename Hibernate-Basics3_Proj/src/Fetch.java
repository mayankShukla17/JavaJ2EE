import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Fetch 
{
	public static void main(String[] args) 
	{
		// it will read hibernate.cfg.xml file
		Configuration cfg = new Configuration();
		cfg.configure();
		System.out.println("Configuraton Done");

		// it will create connections
		// will do ORM
		// will Execute DDL
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println("Factory Done");

		// use connection to perform CRUD
		// execute DML/DQL
		Session session = sessionFactory.openSession();

		Alcohol a1 = session.get(Alcohol.class, new Integer(1));
		System.out.println(a1);

		session.close();
		sessionFactory.close();
	}
}
