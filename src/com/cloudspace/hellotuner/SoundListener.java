package com.cloudspace.hellotuner;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SoundListener {
	
	private Timer timer;
	protected Random rand = new Random();
	
	public SoundListener()  {
	}
	
	private void getDataFromMicrophone()  {
		
	}
	
	private void processSound()  {
		
	}
	
	public int getCurrentDecibels()  {
		return rand.nextInt(100);
	}
	
	public int getHighestDecibels()  {
		return 100;
	}
	
	private void updateBuffers()  {
		getDataFromMicrophone();
		processSound();		
	}
	
	public void start()  {
		timer = new Timer("SoundTimer", true);

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
