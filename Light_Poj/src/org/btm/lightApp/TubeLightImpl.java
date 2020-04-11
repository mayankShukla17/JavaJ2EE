package org.btm.lightApp;
public class TubeLightImpl implements ISwitch
{
	//Implementation Logic
	@Override
	public void sOn() 
	{
		System.out.println("TubeLight Turned Onn!!!");
	}
	@Override
	public void sOff() 
	{
		System.out.println("TubeLight Turned Off!!!");
	}
}
