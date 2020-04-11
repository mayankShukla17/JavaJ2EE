package org.btm.projectorApp;
public class SamsungProjImpl implements IRemote 
{
	// IMPLEMENTATION LOGIC
		@Override
		public void turnOn() 
		{
			System.out.println("Samsung Projector Turned Onn!!");
		}
		@Override
		public void freeze() 
		{
			System.out.println("Screen is Freezed!!");
		}
		@Override
		public void turnOff() 
		{
			System.out.println("Samsung Projector Turned Off!!");
		}
}
