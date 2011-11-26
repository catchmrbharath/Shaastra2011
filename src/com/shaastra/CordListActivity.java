package com.shaastra;

import java.io.IOException;

import com.shaastra.adapters.CordListAdapter;
import com.shaastra.adapters.DatabaseHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class CordListActivity extends ListActivity {
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		int eventId = 4;
		eventId = extras.getInt("eventId");
		Log.e("list Activity ", "event Id "+eventId);
		DatabaseHelper myDbHelper = new DatabaseHelper(this);
		try{
			myDbHelper.createDataBase();
		
			
		}
		catch (IOException ioe){
			throw new Error("database not created");
		}
		myDbHelper.openDataBase();
		
		Cursor cursor = myDbHelper.fetchCordDetails(eventId);
		startManagingCursor(cursor);
		CordListAdapter adapter = new CordListAdapter(this, cursor);
		this.setListAdapter(adapter);
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		TextView phoneView = (TextView)v.findViewById(R.id.cordphone);
		String phone = (String) phoneView.getText();
		final String uri = "tel:"+phone;
		final String messageUri = "sms:"+phone;
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Do you want to call or message the coordinator?")
		       .setCancelable(true)
		       .setPositiveButton("Call", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse(uri));
		                startActivity(intent);
		           }
		       })
		       .setNegativeButton("Message", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		        	   Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(messageUri));
		        	 //  intent.setType("vnd.android-dir/mms-sms");
		                startActivity(intent);
		           }
		       });
		AlertDialog alert = builder.create();
		alert.show();
	}
	

}
