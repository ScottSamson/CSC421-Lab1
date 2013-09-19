package edu.sdsmt.thompsonsamson.lab1;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.view.View;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity1 extends Activity implements OnClickListener {

	// Class members
	private String _message = "";
	private boolean _stateBoolean = false;
	private String _stateBooleanKey = "Activity1";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
						
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity1);
		
		Button buttonStartActivity2 = (Button) findViewById(R.id.button1);
		buttonStartActivity2.setOnClickListener(this);

		// log the message to the console
		_message = this.getString(R.string.activity1_title) + " | " + this.getString(R.string.on_create) + " | StateBoolean = ";

		// if no saved instances, display state value
		// otherwise get the current state value from bundle
		if ( savedInstanceState == null ) {
		_message +=  _stateBoolean;
		}
		else {
			_message += savedInstanceState.getBoolean(_stateBooleanKey);
		}

		Log.d(common.TAG, _message);
	}

	@Override
	public void onClick(View v) {
		callActivity2();
	}

	private void callActivity2()
	{
		Intent intent = new Intent(this, Activity2.class);
		startActivity(intent);
	}
	
	@Override
	protected void onStart() {
		super.onStart();

		// log the message to the console
		_message = this.getString(R.string.activity1_title) + " | " + this.getString(R.string.on_start);
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onStop() {
		super.onStop();
		
		// log the message to the console
		_message = this.getString(R.string.activity1_title) + " | " + this.getString(R.string.on_start);
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onRestart() {
		super.onRestart();

		// log the message to the console
		_message = this.getString(R.string.activity1_title) + " | " + this.getString(R.string.on_restart);
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		// log the message to the console
		_message = this.getString(R.string.activity1_title) + " | " + this.getString(R.string.on_start);
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		// set the pause value
		_stateBoolean = true;
		
		// log the message to the console
		_message = this.getString(R.string.activity1_title) + " | " + this.getString(R.string.on_start);
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		// store the key/pair to the bundle
		outState.putBoolean(_stateBooleanKey, _stateBoolean);
		
		// log the message to the console
		_message = this.getString(R.string.activity1_title) + " | " + this.getString(R.string.on_save) + " | StateBoolean = " + _stateBoolean;
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		
		// get the key/pair from the bundle
		_stateBoolean = savedInstanceState.getBoolean(_stateBooleanKey);
		
		// log the message to the console
		_message = this.getString(R.string.activity1_title) + " | " + this.getString(R.string.on_restore) + " | StateBoolean = " + _stateBoolean;;
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		// log the message to the console
		_message = this.getString(R.string.activity1_title) + " | " + this.getString(R.string.on_destory);
		Log.d(common.TAG, _message);
	}

}
