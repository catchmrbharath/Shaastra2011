package com.shaastra;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


public class MapsActivity extends MapActivity {
	
	
	private MapView map;
	@Override
	protected boolean isRouteDisplayed() {
		
		return false;
	}
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maplayout);
        map = (MapView) findViewById(R.id.mapview);
        MapController controller = map.getController();
        controller.setCenter(getPoint(12.989467,80.232125));
        controller.setZoom(18);
        ;
       
 
       
    }
	
	public GeoPoint getPoint(double latitude,double longitude)
	{
		return new GeoPoint((int)(latitude*1000000.0),(int)(longitude*1000000.0)); 
		
	}
	
	

}
