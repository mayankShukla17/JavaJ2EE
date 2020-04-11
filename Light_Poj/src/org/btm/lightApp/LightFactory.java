package org.btm.lightApp;
public class LightFactory 
{
	//Object Creation Logic
	public static ISwitch getLight(String type) 
	{
		if(type.equalsIgnoreCase("TubeLight"))
		{
			return new TubeLightImpl();
		}
		else if (type.equalsIgnoreCase("LedLight")) 
		{
			return new LedLightImpl();
		}
		else 
		{
			System.err.println("No Light Found");
		}
		return null;
	}
}

