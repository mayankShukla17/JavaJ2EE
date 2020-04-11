package org.btm.projectorApp;

public class ProjectorFactory 
{
	// OBJECT CREATION LOGIC
	public static IRemote getProjector(String type)
	{
		if (type.equalsIgnoreCase("LG")) 
		{
			return new  LgProjImpl();
		}
		else if (type.equalsIgnoreCase("Samsung")) 
		{
			return new SamsungProjImpl();
		}
		else 
		{
		System.err.println("No Projector Found");	
		}
		return null;
	}
}
