package com.shaastra;


import com.shaastra.adapters.EventAdapter;
import com.shaastra.views.EventImage;
import com.shaastra.views.SlowGallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class main extends Activity {
	private EventImage[] events;
	private float scale;

gallerymanager sources;

private DisplayMetrics metrics;
    /** Called when the activity is first created. */

public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    return true;
}
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.maps:
        	
        	Intent i = new Intent(this,MapsActivity.class);
		    
		    this.startActivity(i);
		    break;
        case R.id.coordlist:
        	
        	
        	Intent in = new Intent(this,FullCordListActivity.class);
        	
        	startActivity(in);
        	break;
     
    }
    return true;
}
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	        super.onCreate(savedInstanceState);
    	        sources=new gallerymanager();
    	  
    	         setContentView(R.layout.main);
    	        
    	         Log.v("APP", "reached 1");
    	
    	         // l.setBackgroundResource(R.drawable.slider);
    	       //  TextView t=(TextView) findViewById(R.id.t1);
    	         //t.setTypeface(font1);
    	      
    	         //t.setTextColor(Color.GREEN);
    	         metrics = new DisplayMetrics();
    	         
        	     this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        	     scale = this.getResources().getDisplayMetrics().density;
        			
    	     initialisegalleries();
    	    //     Intent i = new Intent(this,scheduletab.class);
    	     //    startActivity(i);
    	   
}
    public void alignGallery(Gallery gallery)
    {
    	 MarginLayoutParams mlp = (MarginLayoutParams) gallery.getLayoutParams();
		 mlp.setMargins(-(metrics.widthPixels/2+(int)(25*scale + 0.5f)), 
		                mlp.topMargin, 
		                mlp.rightMargin, 
		                mlp.bottomMargin
		 );
    }
    void initialisegalleries()
    {
    
    	 SlowGallery gallery = (SlowGallery) findViewById(R.id.gallery1);
    	 

		 EventAdapter e=new EventAdapter(this,0);
		 gallery.setAdapter(e); 
		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(0, this));
		 alignGallery(gallery);

		 gallery = (SlowGallery) findViewById(R.id.gallery2);
    	 
		 e=new EventAdapter(this,1);
		 gallery.setAdapter(e); 
		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(1, this));

		 alignGallery(gallery);

		 gallery = (SlowGallery) findViewById(R.id.gallery3);
		 e=new EventAdapter(this,2);
		 gallery.setAdapter(e); 
		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(2, this));

		 alignGallery(gallery);
		 gallery = (SlowGallery) findViewById(R.id.gallery4);
		 e=new EventAdapter(this,3);
		 gallery.setAdapter(e); 

		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(3, this));

		 alignGallery(gallery);
		 gallery = (SlowGallery) findViewById(R.id.gallery5);
		 e=new EventAdapter(this,4);
		 gallery.setAdapter(e); 
		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(4, this));

		 alignGallery(gallery);
		 gallery = (SlowGallery) findViewById(R.id.gallery6);
		 e=new EventAdapter(this,5);
		 gallery.setAdapter(e); 

		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(5, this));
		 alignGallery(gallery);
		 gallery = (SlowGallery) findViewById(R.id.gallery7);
	 e=new EventAdapter(this,6);
		 gallery.setAdapter(e); 	
		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(6, this));

		 alignGallery(gallery);
		 gallery = (SlowGallery) findViewById(R.id.gallery8);
		 e=new EventAdapter(this,7);
		 gallery.setAdapter(e); 
		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(7, this));

		 alignGallery(gallery);

		 gallery = (SlowGallery) findViewById(R.id.gallery9);
		 e=new EventAdapter(this,8);
		 gallery.setAdapter(e); 
		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(8, this));

		 alignGallery(gallery);
		 gallery = (SlowGallery) findViewById(R.id.gallerya);
		 e=new EventAdapter(this,9);
		 gallery.setAdapter(e);
		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(9, this));

		 alignGallery(gallery);//gallery.setAdapter(e); 
	 gallery = (SlowGallery) findViewById(R.id.galleryb);
		 e=new EventAdapter(this,10);
		 gallery.setAdapter(e); 
		 gallery.setOnItemClickListener((OnItemClickListener) new GalleryClickListener(10, this));

		 alignGallery(gallery);

    }
  
    }
    

    
 


