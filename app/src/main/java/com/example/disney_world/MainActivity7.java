package com.example.disney_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity7 extends AppCompatActivity {

	private EditText labelField;
	private EditText urlField;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_7);

		labelField = findViewById(R.id.label);
		urlField = findViewById(R.id.url);

		Bundle extras = getIntent().getExtras();
		String label = extras.getString(MainActivity8.label_key);
		String url = extras.getString(MainActivity8.URL_key);

		labelField.setText(label);
		urlField.setText(url);

		Button okBtn = findViewById(R.id.btn_ok);
		okBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent data = new Intent();
				Bundle bundle = new Bundle();

				bundle.putString(MainActivity8.label_key, labelField.getText().toString());
				bundle.putString(MainActivity8.URL_key, urlField.getText().toString());
				data.putExtras(bundle);
				setResult(RESULT_OK, data);
				finish();
			}
		});
		Button cancelBtn = findViewById(R.id.btn_cancel);
		cancelBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				setResult(RESULT_CANCELED);
				finish();
			}
		});
	}
}
