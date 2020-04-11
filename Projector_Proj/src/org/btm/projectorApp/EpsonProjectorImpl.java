package org.btm.projectorApp;
public class EpsonProjectorImpl implements IRemote
{
	//Implementation Logic
	@Override
	public void turnOn() 
	{
		System.out.println("Epson Projector Turned On!!");
	}
	@Override
	public void turnOff() 
	{
		System.out.println("Epson Projector Turned Off!!");		
	}
	@Override
	public void freeze() 
	{
		System.out.println("Epson Projector Freezed!!");		
	}
}
