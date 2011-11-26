package com.shaastra.adapters;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.shaastra.R;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	

	private static String DB_PATH = "/data/data/com.shaastra/databases/";
	private static String DB_NAME = "test.db";
	private static String TAG = "Databasehelper";
	private static String TABLE_NAME = "events";
	private static String KEY_EVENT_ID = "_id";
	private static String NAME = "name";
	private static String DESCRIPTION = "desc";
	private static String INTRODUCTION = "introduction";
	private static String PRIZE = "prize";
	
    private SQLiteDatabase myDatabase; 
    private final Context myContext;
    
    public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		this.myContext=context;
		
	}
    public DatabaseHelper(Context context) {
    	 
    	super(context, DB_NAME, null, 1);
        this.myContext = context;
    }	
	
	public void createDataBase() throws IOException{
		 boolean dbExist = checkDataBase();
		 if(dbExist){}
		 else
		 {
			 //By calling this method and empty database will be created into the default system path
		 //of your application so we are gonna be able to overwrite that database with our database.
			 this.getReadableDatabase();
 
			 try {
				 copyDataBase();
			 } 
			 catch (IOException e) 
			 {
        	throw new Error("Error copying database "+e.toString());
			 }
		 }
	}
	
	
	
	 private boolean checkDataBase(){
		 
	    	SQLiteDatabase checkDB = null;
	 
	    	try{
	    		String myPath = DB_PATH + DB_NAME;
	    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
	 
	    	}catch(SQLiteException e){
	 
	    		Log.e("database",e.toString());
	 
	    	}
	 
	    	if(checkDB != null){
	 
	    		checkDB.close();
	 
	    	}
	 
	    	return checkDB != null ? true : false;
	    }
	 
	 /**
	     * Copies your database from your local assets-folder to the just created empty database in the
	     * system folder, from where it can be accessed and handled.
	     * This is done by transferring byte stream.
	     * */
	    private void copyDataBase() throws IOException{
	 
	    	//Open your local db as the input stream
	    	InputStream myInput = myContext.getAssets().open(DB_NAME);
	 
	    	// Path to the just created empty db
	    	String outFileName = DB_PATH + DB_NAME;
	 
	    	//Open the empty db as the output stream
	    	OutputStream myOutput = new FileOutputStream(outFileName);
	 
	    	//transfer bytes from the inputfile to the outputfile
	    	byte[] buffer = new byte[1024];
	    	int length;
	    	while ((length = myInput.read(buffer))>0){
	    		myOutput.write(buffer, 0, length);
	    	}
	 
	    	//Close the streams
	    	myOutput.flush();
	    	myOutput.close();
	    	myInput.close();
	 
	    }

	    
	 public void openDataBase() throws SQLException{
	    	 
	    	//Open the database
	        String myPath = DB_PATH + DB_NAME;
	    	myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
	 
	    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		
	}

	 @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     	Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                 + newVersion + ", which will destroy all old data");
         db.execSQL("DROP TABLE IF EXISTS events");
         onCreate(db);
     }
 
	 

	
	public synchronized void close() {

	    if(myDatabase != null)
		    myDatabase.close();

	    super.close();

	}
	   public Cursor fetchDescription(long eventId) throws SQLException {

	        Cursor mCursor =

	                myDatabase.query(true, TABLE_NAME, new String[] {KEY_EVENT_ID,NAME,
	                        DESCRIPTION,INTRODUCTION,PRIZE}, KEY_EVENT_ID + "=" + eventId, null,
	                        null, null,null, null);
	        if (mCursor != null) {
	            mCursor.moveToFirst();
	        }
	        return mCursor;

	    }
	   public Cursor fetchDescription(long eventId,String title) throws SQLException {

		   Long id = Long.valueOf(eventId);
	        Cursor mCursor =

	                myDatabase.query(TABLE_NAME, new String[] {KEY_EVENT_ID,NAME,
	                        DESCRIPTION}, KEY_EVENT_ID+"= ? AND "+NAME+"= ?",new String[]{id.toString(),title},
	                         null,null,null);
	        if (mCursor != null) {
	            mCursor.moveToFirst();
	        }
	        return mCursor;

	    }
	   
	   public Cursor fetchCordDetails(long eventId) throws SQLException{
		   Cursor mCursor;
		   if(eventId!=0){
		   Long id = Long.valueOf(eventId);
		  
		   mCursor =myDatabase.query("Coordinators", new String[]{"_id","name","phone","eventid"}, "eventid= ?", new String[]{id.toString()}, null, null,null);
		   if(mCursor!=null){
			   mCursor.moveToFirst();
		   }
		   }
		   else{
			   mCursor =myDatabase.query("Coordinators", new String[]{"_id","name","phone","eventid"}, null,null, null, null,null);
			   if(mCursor!=null){
				   mCursor.moveToFirst();
			   }
		   }
		   return mCursor;
	   }
	   
	   public Cursor fetchAllCords() throws SQLException{
		   Cursor mCursor;
		   
		   mCursor =myDatabase.query("coords", new String[]{"_id","name","phone","dept"},null,null, null, null,null);
		   if(mCursor!=null){
			   mCursor.moveToFirst();
		   }
		   
		  
		   return mCursor;
	   }
	   
	   public Cursor fetchCords(String search) throws SQLException{
		   Cursor mCursor;
		   mCursor = myDatabase.query("coords", new String[]{"_id","name","phone","dept"},"name like ? or dept like ?", new String[]{"%"+search+"%","%"+search+"%"},null,null,null);
		   if(mCursor!=null){
			   mCursor.moveToFirst();
		   }
		   return mCursor;
	   }

	
	


}
