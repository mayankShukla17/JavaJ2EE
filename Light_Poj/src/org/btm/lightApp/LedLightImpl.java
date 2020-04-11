package org.btm.lightApp;
public class LedLightImpl implements ISwitch
{
	//Implementation Logic
	@Override
	public void sOn() 
	{
		System.out.println("LedLight Turned Onn!!!");
	}
	@Override
	public void sOff() 
	{
		System.out.println("LedLight Turned Off!!!");
	}
}
