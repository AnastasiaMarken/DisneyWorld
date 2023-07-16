package com.example.disney_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

	public static MainActivity2 mainActivity2;
	private Button btn_0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);

		mainActivity2 = this;

		initButton();
	}
	private void initButton() {
		btn_0 = this.findViewById(R.id.btn_log);

		btn_0.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(mainActivity2, MainActivity4.class);
				startActivity(intent);
			}
		});

	}
}
