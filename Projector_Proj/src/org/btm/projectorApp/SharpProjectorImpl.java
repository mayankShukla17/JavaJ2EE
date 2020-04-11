package org.btm.projectorApp;
public class SharpProjectorImpl implements IRemote
{
	//Implementation Logic
	@Override
	public void turnOn() 
	{
		System.out.println("Sharp Projector Turned On!!");
	}
	@Override
	public void turnOff() 
	{
		System.out.println("Sharp Projector Turned Off!!");		
	}
	@Override
	public void freeze() 
	{
		System.out.println("Sharp Projector Freezed!!");		
	}
}
