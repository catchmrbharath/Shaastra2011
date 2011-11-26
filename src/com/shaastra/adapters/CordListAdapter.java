package com.shaastra.adapters;

/*
 * @author Bharath M R
 * catchmrbharath@gmail.com
 * This class is an custom cursor adapter.
 */


import java.util.HashMap;

import com.shaastra.R;
import com.shaastra.gallerymanager;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CordListAdapter extends CursorAdapter {
	
	private Cursor cursor;
	private Context mContext;
	private final LayoutInflater inflator;
	
	public CordListAdapter(Context context, Cursor c) {
		super(context, c);
		inflator = LayoutInflater.from(context);
		mContext = context;
		
	}

	@Override
	/*
	 * This method maps the contents on the cursor onto the listview. The layout is defined in
	 * item_list_view. The textview and the image view are inflated.
	 */
	public void bindView(View view, Context context, Cursor cursor) {
		TextView name = (TextView) view.findViewById(R.id.cordname);
		TextView number = (TextView) view.findViewById(R.id.cordphone);
		TextView eventName = (TextView) view.findViewById(R.id.cordEvent);
		if(cursor!=null){
		int eventId = cursor.getInt(3);
		int dataId = 0;
		HashMap<Integer,Integer> temp = gallerymanager.hackHash;
		for(int i=1;i<=gallerymanager.hackHash.size();i++){
			if(temp.get(i)!=null){
				if(temp.get(i)==eventId){
					dataId = i; 
				}
			}
			
		}
		String namestr = cursor.getString(1);
		name.setText(namestr);
		String phonestr = cursor.getString(2);
		number.setText(phonestr);
		if(dataId!=0)
		eventName.setText(gallerymanager.eventNameHash.get(dataId));
		else
			eventName.setText("");
		}
		
		
	}
	
	
	/*inflates the layout xml file */
	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		final View view = inflator.inflate(R.layout.cordlist,parent,false);
		return view;
	}

}