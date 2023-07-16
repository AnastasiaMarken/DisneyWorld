package com.example.disney_world;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

	public static MainActivity mainActivity;
	private Button btn_0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mainActivity = this;

		initButtons();
	}


	private void initButtons() {
		btn_0 = this.findViewById(R.id.button);

		btn_0.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(mainActivity, MainActivity2.class);
				startActivity(intent);
			}
		});
	}
}
