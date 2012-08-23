package com.cloudspace.hellotuner;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.util.Log;

public class SoundListener {

	private AudioRecord recorder;
	private int recorderBufferSize;
	private short[] recorderBuffer;
	private int currentDecibels = 0;
	
	private Timer timer;
	
	public SoundListener()  {
		int sampleRate = AudioTrack.getNativeOutputSampleRate(AudioManager.STREAM_SYSTEM);
		recorderBufferSize = AudioRecord.getMinBufferSize(sampleRate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);

		recorder = new AudioRecord(
				MediaRecorder.AudioSource.MIC, 
				sampleRate, 
				AudioFormat.CHANNEL_IN_MONO, 
				AudioFormat.ENCODING_DEFAULT, 
				recorderBufferSize);	
		recorderBuffer = new short[recorderBufferSize];

	}

	
	public int getCurrentDecibels()  {
		Log.e("current decibels", currentDecibels + "");
		return currentDecibels;
	}
	
	public int getHighestDecibels()  {
		return 100;
	}
	
	private void updateBuffers()  {
		recorder.read(recorderBuffer,0,recorderBufferSize);
		//randomly chose 1000, not sure what the buffer contents actually are
		currentDecibels = recorderBuffer[1000];		
	}
	
	//information here: http://stackoverflow.com/questions/4871149/how-to-record-voice-in-wav-formt-using-android
	public void start()  {
		recorder.startRecording();

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
		//stop recording
		recorder.stop();
		//stop the timertask
		timer.cancel();
	}

}
