package com.example.pocketchef;

import com.example.pocketchef.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class ManualItemAdd extends Activity {

	
	public final static String ITEM = "ITEM";
	
	private Spinner quantity_spinner;
//	private Button button_add;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manual_item_add);
		// Show the Up button in the action bar.
		
		setupSpinner();
	//	setupListenerOnExpirationButton();
	//	setupListenerOnAddButton();
		setupActionBar();
	}
	
	public void setupSpinner() {
		
		quantity_spinner = (Spinner) findViewById(R.id.quantity_spinner);
		quantity_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manual_item_add, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	/* I think I will just use listeners
	public void sendItem(View view) {
		
	//	Intent intent = new Intent(this, ItemInventory.class);
		AutoCompleteTextView textField = (AutoCompleteTextView) findViewById(R.id.item_add);
		String name = textField.getText().toString();
		Spinner quantitySpinner = (Spinner) findViewById(R.id.spinner_quantity);
	//	int quantity = quantitiy.get
		
	//	intent.putExtra(name, quantity);
	//	startActivity(intent);
	}
	*/

}
