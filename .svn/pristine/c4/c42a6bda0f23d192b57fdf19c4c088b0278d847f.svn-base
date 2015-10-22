package com.example.pocketchef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;


// DEPRECATED

public class DecodeUPC implements Runnable {

	Barcode b;
	
	public DecodeUPC(String upc) {
		b = new Barcode (upc);
	}
	
	@Override
	public void run() {

	    	//Barcode b = new Barcode("0085239665169");  // hardcoded test
	    	 String result = "";
	    	 
	         try {
	         	String jsonResult = "";
	         	
	         	// Incorrect URL? Or the website is down right now..
	         	URL api = new URL("http://www.upcdatabase.org/api/json/033e3f98" +
	         			"478c2eb2d64aa3f79a5d3e93/" + b.getCode());
	         	
	         	
	         	System.out.println("URL: " + api);
	 	        URLConnection con = api.openConnection();

	 	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	 	        String inputLine;
	 	        while ((inputLine = in.readLine()) != null) {
	 	        	jsonResult += inputLine;
	 	             System.out.println(inputLine);
	 	        }
	 	        in.close();

	 	        JSONObject json = new JSONObject(jsonResult); // convert jsonResult to JSONObject
	 	        
	 	        if (!json.isNull("itemname") && json.getString("itemname") != null) {
	 	        	result = json.getString("itemname");
	 	        }
	 	        if (result == null || result == "") {
	 	        	return; // or throw
	 	        }
	         }
	         catch (IOException e) {
	         	System.out.println("Error reading json: " + e);
	         }
	         catch (JSONException e) {
	         	System.out.println("Error parsing json: " + e);
	         }

	 		 System.out.println("RESULT:\n" + result); // Print out the item!
	    }
	}
