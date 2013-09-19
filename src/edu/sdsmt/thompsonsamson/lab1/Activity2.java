package edu.sdsmt.thompsonsamson.lab1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class Activity2 extends Activity {

	// Class members
	private String _message = "";
	private boolean _stateBoolean = false;
	private String _stateBooleanKey = "Activity2";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2);
		
		// log the message to the console
		_message = this.getString(R.string.activity2_title) + " | " + this.getString(R.string.on_create) + " | StateBoolean = ";

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

	public void callActivity3(View v)
	{
		Intent intent = new Intent(this, Activity3.class);
		startActivity(intent);
	}
	
	public void finishActivity2(View v)
	{
		this.finish();
	}

	@Override
	protected void onStart() {
		super.onStart();

		// log the message to the console
		_message = this.getString(R.string.activity2_title) + " | " + this.getString(R.string.on_start);
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onStop() {
		super.onStop();
		
		// log the message to the console
		_message = this.getString(R.string.activity2_title) + " | " + this.getString(R.string.on_start);
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onRestart() {
		super.onRestart();

		// log the message to the console
		_message = this.getString(R.string.activity2_title) + " | " + this.getString(R.string.on_restart);
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		// log the message to the console
		_message = this.getString(R.string.activity2_title) + " | " + this.getString(R.string.on_start);
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		// set the pause value
		_stateBoolean = true;
		
		// log the message to the console
		_message = this.getString(R.string.activity2_title) + " | " + this.getString(R.string.on_start);
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		// store the key/pair to the bundle
		outState.putBoolean(_stateBooleanKey, _stateBoolean);
		
		// log the message to the console
		_message = this.getString(R.string.activity2_title) + " | " + this.getString(R.string.on_save) + " | StateBoolean = " + _stateBoolean;
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		
		// get the key/pair from the bundle
		_stateBoolean = savedInstanceState.getBoolean(_stateBooleanKey);
		
		// log the message to the console
		_message = this.getString(R.string.activity2_title) + " | " + this.getString(R.string.on_restore) + " | StateBoolean = " + _stateBoolean;;
		Log.d(common.TAG, _message);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		// log the message to the console
		_message = this.getString(R.string.activity2_title) + " | " + this.getString(R.string.on_destory);
		Log.d(common.TAG, _message);
	}


}
