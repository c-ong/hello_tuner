package com.cloudspace.hellotuner;

import java.util.Timer;
import java.util.TimerTask;

public class SoundListener {
	
	private Timer timer;
	
	public SoundListener()  {
		timer = new Timer("SoundTimer", true);
	}
	
	private void getDataFromMicrophone()  {
		
	}
	
	private void processSound()  {
		
	}
	
	public int getCurrentDecibels()  {
		return 10;
	}
	
	public int getHighestDecibels()  {
		return 100;
	}
	
	private void updateBuffers()  {
		getDataFromMicrophone();
		processSound();		
	}
	
	public void start()  {
		//start calling run in a timertask
		TimerTask timerTask = new TimerTask(){
			public void run()  {
				updateBuffers();
			}
		};
		timer.scheduleAtFixedRate(timerTask, 0, 100);
	}
	
	public void stop()  {
		//stop the timertask
		timer.cancel();
	}

}
