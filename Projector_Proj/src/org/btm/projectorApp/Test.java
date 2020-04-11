package org.btm.projectorApp;
import java.util.Scanner;
public class Test 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the projector?");
		String type=sc.next();
		sc.close();
		IRemote ir=ProjectorFactory.getProjector(type);
		if (ir!=null) 
		{
			ir.turnOn();
			ir.freeze();
			ir.turnOff();
		}
	}
}
