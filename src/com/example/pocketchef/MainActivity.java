package com.example.pocketchef;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.CallableStatement;

import com.dm.zbar.android.scanner.ZBarConstants;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener
{
	private Button scanBtn;
	
	private Button registerBtn;
	private TextView dbTxt;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		scanBtn = (Button) findViewById(R.id.scan_button);
		scanBtn.setOnClickListener(this);
		
		// Tyler's database test button thing
		registerBtn = (Button) findViewById(R.id.button01);
		dbTxt = (TextView) findViewById(R.id.textView1);
		registerBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View v)
	{
		if (v.getId() == R.id.scan_button)
		{
			// New scan code. Objectified.
			Intent intent = new Intent(this, ScannerUPC.class);
			startActivityForResult(intent, PocketChefConstants.ZBAR_SCANNER_REQUEST);
		}
		if (v.getId() == R.id.button01)
		{
			int userIDs[] = { 0 };
			new DatabaseTestTask().execute(userIDs);
		}
	}

	private class DatabaseTestTask extends AsyncTask<int[], Void, String>
	{
		private static final String url = "jdbc:mysql://mysql.cs.iastate.edu/db30910";
	    private static final String user = "u30910";
	    private static final String pass = "YSBGwKwZN";

		@Override
		protected String doInBackground(int[]... params) {
			Connection con;
			String success = "Failed";
			try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = DriverManager.getConnection(url, user, pass);
	            success = "Connected!";
	            
	            CallableStatement cs = null;
	            ResultSet rs = null;
	        	cs = (CallableStatement) con.prepareCall("{call Users_GetUserByID(?)}");
	        	cs.setFloat(1, params[0][0]);
	        	rs = cs.executeQuery();
	        	rs.next();
	        	success = rs.getString(2);
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
			
			return success;
		}
		
		protected void onPostExecute(String result)
		{
			dbTxt.setText(result);
		}
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		String content = data.getStringExtra(PocketChefConstants.DECODE_RESULT);
			
		// Do something with result here.
		Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
	}
}
