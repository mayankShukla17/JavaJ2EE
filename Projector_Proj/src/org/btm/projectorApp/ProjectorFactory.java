package org.btm.projectorApp;
public class ProjectorFactory 
{
	//Object Creation Logic
	public static IRemote getProjector(String type) 
	{
		if(type.equalsIgnoreCase("Epson")) 
		{
			return new EpsonProjectorImpl();
		}
		else if (type.equalsIgnoreCase("Sharp")) 
		{
			return new SharpProjectorImpl();
		}
		else 
		{
			System.err.println("No Projector Found!!");
		}
		return null;
	}
}
