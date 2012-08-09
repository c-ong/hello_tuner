package com.cloudspace.hellotuner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity implements OnClickListener {

	private Listener listener = new Listener();
	private boolean running = false;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = (Button)findViewById(R.id.start);
        start.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		switch(v.getId())  {
		case R.id.start:
			if(running)  {
				listener.stop();
				Button button = (Button) v;
				button.setText(getResources().getString(R.string.stop));
				running = false;
			} else {
				listener.start();
				Button button = (Button) v;
				button.setText(getResources().getString(R.string.start));
				running = true;
			}			
			break;
		}		
	}   
}
