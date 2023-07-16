package com.example.disney_world;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.disney_world.adapters.cartoons.CatroonAdapter;

import java.util.ArrayList;

public class MainActivity6 extends Activity {

	String [] strings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_6);

		final RecyclerView cartoonList = findViewById(R.id.cartoonList);
		cartoonList.setLayoutManager(new LinearLayoutManager(this));

		ArrayList<String> mults = new ArrayList<>();
		strings = getResources().getStringArray(R.array.strings);

		for(int i = 0; i < strings.length; i++)
			mults.add(strings[i]);

		CatroonAdapter adapter = new CatroonAdapter(this, mults);
		cartoonList.setAdapter(adapter);
	}
	/*public void onListItemClick (ListView parent, View view, int position, long id) {
		parent.setItemChecked(position, parent.isItemChecked(position));
		Toast.makeText(this,  strings[position] + " has been viewed", Toast.LENGTH_SHORT).show();
	}*/
}
