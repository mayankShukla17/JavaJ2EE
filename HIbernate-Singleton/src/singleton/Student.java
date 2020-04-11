package singleton;
public class Student 
{
	private final static Student s;
	static 
	{
		s = new Student();
	}
	private Student() 
	{
		super();
	}
	public final synchronized 
	static Student studentFactory()
	{
		return s;
	}
}
