import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Runner 
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure();
		System.out.println("Configuration Done");
		
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		System.out.println("Factory done");
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Human ram=new Human();
//		human.setId(1); // this line is not needed in when @Generated Value is usedS
		ram.setName("MKS");
		
//		Serializable pk=session.save(ram);
//		Integer xyz=(Integer)pk;
//		int abz=xyz;
//		System.out.println(xyz);
		
		int pk1=(int)session.save(ram);
		System.out.println(pk1);
		
//		session.save(ram);
		
		transaction.commit();
	}
}
