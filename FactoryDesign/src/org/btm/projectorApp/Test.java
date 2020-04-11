package org.btm.projectorApp;
import java.util.Scanner;
public class Test 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Projector Name??");
		String type = sc.next();
		sc.close();
		IRemote re=ProjectorFactory.getProjector(type);
		if (re!=null) 
		{
			re.turnOn();
			re.freeze();	// CONSUMER OR UTILIZATION LOGIC	
			re.turnOff();
		}
	}
}
