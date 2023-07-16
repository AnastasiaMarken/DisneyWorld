package com.example.disney_world.adapters.cartoons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.disney_world.R;

import java.util.ArrayList;

public class CatroonAdapter extends RecyclerView.Adapter {

	private Context ctx;
	private LayoutInflater lInflater;
	private ArrayList<String> objects;

	public static class CartoonHolder extends RecyclerView.ViewHolder  {
		CheckBox chMult;

		public CartoonHolder(View itemView){
			super (itemView);

			chMult = itemView.findViewById(R.id.chMult);
		}
	}

	public CatroonAdapter(Context context, ArrayList<String> cartoons) {
		ctx = context;
		objects = cartoons;
		lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public CartoonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartoon_item, parent, false);
		CartoonHolder myViewHolder = new CartoonHolder(view);

		return myViewHolder;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		final String item = objects.get(position);
		final CheckBox chMult = ((CartoonHolder) holder).chMult;

		chMult.setText(item);

		chMult.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				boolean is_select = ((CheckBox) view).isChecked();

				if (is_select) {
					Toast.makeText(ctx,  "Cartoon has been viewed", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getItemCount() {
		return objects.size();
	}

}
