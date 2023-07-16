package com.example.disney_world;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

	private RadioGroup RG1;
	private Button btn_1, btn_2;
	private EditText ED;

	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_5);

		RG1 = findViewById(R.id.RG);
		RG1.setOnCheckedChangeListener(radio);

		btn_1 = findViewById(R.id.btn5_1);
		btn_1.setOnClickListener(btnListener);

		btn_2 = findViewById(R.id.btn5_2);
		btn_2.setOnClickListener(btnListener);

		ED = findViewById(R.id.EdText);
	}

	private View.OnClickListener btnListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			int id = view.getId();
			switch (id){
				case R.id.btn5_1:
					String text = ED.getText().toString();
					Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT).show();
					break;
				case R.id.btn5_2:
					ED.setText("");
					break;
			}
		}
	};
	private RadioGroup.OnCheckedChangeListener radio = new RadioGroup.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
			RadioButton rb = findViewById(checkedId);
			ED.setText(rb.getText().toString());
		}
	};
}
