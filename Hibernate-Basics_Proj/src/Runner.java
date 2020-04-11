import org.hibernate.cfg.Configuration;
public class Runner 
{
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		System.out.println("Configuration Done");
		cfg.buildSessionFactory();
		System.out.println("Factory Done");
	}
}
