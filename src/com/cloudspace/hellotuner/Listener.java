package com.cloudspace.hellotuner;

public class Listener {
	
	public Listener()  {
	}
	
	private void getDataFromMicrophone()  {
		
	}
	
	private void processSound()  {
		
	}
	
	public int getCurrentDecibels()  {
		return 0;
	}
	
	public int getHighestDecibels()  {
		return 0;
	}
	
	private void run()  {
		getDataFromMicrophone();
		processSound();		
	}
	
	public void start()  {
		//start calling run in a timertask
	}
	
	public void stop()  {
		//stop the timertask
	}

}
