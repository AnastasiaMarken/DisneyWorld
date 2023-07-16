package com.example.disney_world;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity4 extends Activity {

	public static MainActivity4 mainActivity4;
	String [] menu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_4);

		mainActivity4 = this;

		ListView list_1 = findViewById(R.id.list_1);
		menu = getResources().getStringArray(R.array.menu);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
		list_1.setAdapter(adapter);


		list_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				openActivity(menu[position]);
			}
		});
	}
	private void openActivity(String menuLabel){
		String name = menuLabel;
		if(name == menu[0]){
			Intent intent = new Intent(mainActivity4, MainActivity3.class);
			startActivity(intent);
		}
		if(name == menu[1]){
			Intent intent = new Intent(mainActivity4, MainActivity5.class);
			startActivity(intent);
		}
		if(name == menu[2]){
			Intent intent = new Intent(mainActivity4, MainActivity6.class);
			startActivity(intent);
		}
		if(name == menu[3]){
			Intent intent = new Intent(mainActivity4, MainActivity8.class);
			startActivity(intent);
		}
	}
}
