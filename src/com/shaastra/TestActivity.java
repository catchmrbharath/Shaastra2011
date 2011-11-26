package com.shaastra;


import java.io.IOException;

import com.shaastra.adapters.DatabaseHelper;
import com.shaastra.views.SegmentedControlButton;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TestActivity extends Activity {
	private int eventId;
	private DatabaseHelper myDbHelper;
	private Cursor mCursor;
	private String name;
	private String category;

	private TextView mDescriptionTextView;
	private TextView mIntroLabel;
	private String introduction;
	private String eventFormat;
	private Button mIntroduction;
	private Button mEventFormat;
	private int mPrize;
	private TextView prizeMoney;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myDbHelper = new DatabaseHelper(this);
		try{
			myDbHelper.createDataBase();
		
			
		}
		catch (IOException ioe){
			throw new Error("database not created");
		}
		eventId = 1;
		setContentView(R.layout.description_activity);
		  Bundle extras = getIntent().getExtras();
	        if (extras != null) {
	        	gallerymanager g=new gallerymanager();
	        	eventId=extras.getInt("valueid");
	            name=g.eventNameHash.get(eventId);
	            category=extras.getString("valuecategory");
	       TextView t=(TextView)findViewById(R.id.event_category);
	       t.setText(name);
	       prizeMoney = (TextView) findViewById(R.id.prizeMoney);
	      // t=(TextView)findViewById(R.id.eventName);
	       //t.setText(title);
	       ImageView i=(ImageView)findViewById(R.id.event_image);
	       i.setImageResource(g.imageIDs[eventId-1]);
	        }
	       
	        mDescriptionTextView = (TextView) findViewById(R.id.eventDescription);
	        mIntroLabel = (TextView) findViewById(R.id.introLabel);
		
		
		myDbHelper.openDataBase();
		eventId = gallerymanager.hackHash.get(eventId);
		Log.e("event id", "event Id "+eventId);
		mCursor = myDbHelper.fetchDescription(eventId);
		introduction = mCursor.getString(3);
		mPrize = mCursor.getInt(4);
		if(mPrize==0)
			prizeMoney.setText("Not Applicable");
		else
			prizeMoney.setText("Rs. "+mPrize);
		Log.e("check","event description "+introduction);
		eventFormat = mCursor.getString(2);
		Log.e("temo",""+mPrize);
		
		 
		mIntroduction = (Button) findViewById(R.id.intro);
		mEventFormat = (Button) findViewById(R.id.eventFormat);
	    EventListener mEventListener = new EventListener();
		mIntroduction.setOnClickListener(mEventListener);
		mEventFormat.setOnClickListener(mEventListener );
		mDescriptionTextView.setText(introduction);
		myDbHelper.close();
		
		
		
	}
	private class EventListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			mEventFormat.setSelected(false);
			mEventFormat.setSelected(false);
			Button temp = (Button) v;
			v.setSelected(true);
			v.setSelected(true);
			if(v.getId()==R.id.intro){
				mDescriptionTextView.setText(introduction);
				mIntroLabel.setText("Introduction");
			}
			else{
				mDescriptionTextView.setText(eventFormat);
				mIntroLabel.setText("Event Format");
			}
			// TODO Auto-generated method stub
			
		}
		
	}
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.maps:
	        	
	        	Intent i = new Intent(this,MapsActivity.class);
			    
			    this.startActivity(i);
			    break;
	        case R.id.coordlist:
	        	Bundle extras = new Bundle();
	        	extras.putInt("eventId",this.eventId);
	        	Intent in = new Intent(this,CordListActivity.class);
	        	in.putExtras(extras);
	        	startActivity(in);
	        	break;
	     
	    }
	    return true;
	}
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu, menu);
	    return true;
}
}


