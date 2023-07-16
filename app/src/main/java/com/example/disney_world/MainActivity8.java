package com.example.disney_world;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity8 extends Activity {

	public final static int success_code = 100;
	public final static String label_key = "label";
	public final static String URL_key = "key";
	Map <String, String> mListData;
	String [] mListItems;
	TextView mSelectedListItem = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_8);

		ListView list = findViewById(R.id.list);

		mListData = new HashMap<String, String >();
		mListData.put("Official store", "https://www.shopdisney.com/");
		mListData.put("Official site Walt Disney", "https://disney.ru/");
		mListData.put("Youtube Channel", "https://www.youtube.com/user/disneychannel");
		mListData.put("Theme Parks", "https://disneyworld.disney.go.com/");
		mListData.put("Online Games", "https://disney.ru/games");
		mListData.put("Contests", "https://disney.ru/contests");
		mListData.put("Disney Vacation Club", "https://disneyvacationclub.disney.go.com/");
		mListData.put("Twitter", "https://twitter.com/waltdisneyworld/");
		mListData.put("Disney Channel", "https://www.disneychannel.ca/");
		mListData.put("Gift Cards", "https://www.disneygiftcard.com/");
		mListData.put("Disney's Fairy Tale Weddings & Honeymoons", "https://www.disneyweddings.com/");


		mListItems = mListData.keySet().toArray(new String[0]);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mListItems);
		list.setAdapter(adapter);


		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				openURL(mListItems[position]);
			}
		});

		registerForContextMenu(list);
	}

	@Override
	public void onCreateContextMenu (ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
		super.onCreateContextMenu(menu, view, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
	}

	@Override
	public boolean onContextItemSelected (MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
		mSelectedListItem = (TextView) info.targetView;
		String menuItemLabel = mSelectedListItem.getText().toString();

		switch (item.getItemId()){
			case R.id.open:
				openURL(menuItemLabel);
				return true;
			case R.id.edit:
				Intent i = new Intent("com.example.hello_world.MainActivity7");
				Bundle extras = new Bundle();
				extras.putString(label_key, menuItemLabel);
				extras.putString(URL_key, mListData.get(menuItemLabel));
				i.putExtras(extras);
				startActivityForResult(i, success_code);
				return true;

				default:
					return super.onContextItemSelected(item);
		}
	}

	public void onActivityResult (int requestCode, int resultCode, Intent data) {
		if (requestCode == success_code && resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			if (bundle != null) {
				String label = bundle.getString(label_key);
				String url = bundle.getString(URL_key);
				TextView textView = mSelectedListItem;
				textView.setText(label);
				mListData.remove(label, url);
				mListData.put(label, url);
			}
		}
	}

	private void openURL(String menuLabel){
		String url = mListData.get(menuLabel);
		Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(i);
	}
}
