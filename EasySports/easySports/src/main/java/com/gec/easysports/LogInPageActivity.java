package com.gec.easysports;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LogInPageActivity extends Activity implements OnClickListener {
	private TextView login, register, skip;
	CallbackManager callbackManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FacebookSdk.sdkInitialize(getApplicationContext());
		callbackManager = CallbackManager.Factory.create();
		getWindow().requestFeature(Window.FEATURE_NO_TITLE); // Removing
																// ActionBar
		setContentView();
	}

	private void setContentView()
	{
		EditText loginText;
		EditText passText;

		setContentView(R.layout.activity_login_page_travel);

		login = (TextView) findViewById(R.id.login);
		register = (TextView) findViewById(R.id.register);

		login.setOnClickListener(this);
		register.setOnClickListener(this);

		LoginButton lgFacebook = (LoginButton) findViewById(R.id.login_button_facebook);
		lgFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
			@Override
			public void onSuccess(LoginResult loginResult) {

			}

			@Override
			public void onCancel() {

			}

			@Override
			public void onError(FacebookException error) {

			}
		});
	}
	@Override
	public void onClick(View v) {
		if (v instanceof TextView) {
			TextView tv = (TextView) v;
			Toast.makeText(this, tv.getText(), Toast.LENGTH_SHORT).show();
		}
		switch (v.getId()) {
		case R.id.login:
			Intent intentMain = new Intent(LogInPageActivity.this,
					MainActivity.class);
			startActivity(intentMain);
			break;
		case R.id.register:
			Intent intentRegister = new Intent(LogInPageActivity.this,
					RegisterPageActivity.class);
			startActivity(intentRegister);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		callbackManager.onActivityResult(requestCode, resultCode, data);
	}
}
