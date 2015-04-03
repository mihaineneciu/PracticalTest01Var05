package ro.pub.cs.systems.pdsd.practicaltest01var05;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends Activity {

	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	private int regNo = 0;
	
	private class ButtonClickListener implements Button.OnClickListener {
		
		@Override
		public void onClick(View view) {
			TextView coordText = (TextView)PracticalTest01Var05MainActivity.this.findViewById(R.id.coord);
			String coord = coordText.getText().toString();
			switch(view.getId()) {
				case R.id.navigate_to_secondary_activity_button:
					Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01Var05SecondaryActivity");
					intent.putExtra("coord", coord);
					intent.putExtra("regNo", String.valueOf(regNo));
					startActivityForResult(intent, 1);
					break;
				case R.id.north:
					if(coord.isEmpty()){
						coord = "North";
					}
					else{
						coord = coord.concat(", North");
					}
					coordText.setText(coord);
					break;
				case R.id.west:
					if(coord.isEmpty()){
						coord = "West";
					}
					else{
						coord = coord.concat(", West");
					}
					coordText.setText(coord);
					break;
				case R.id.east:
					if(coord.isEmpty()){
						coord = "East";
					}
					else{
						coord = coord.concat(", East");
					}
					coordText.setText(coord);
					break;
				case R.id.south:
					if(coord.isEmpty()){
						coord = "South";
					}
					else{
						coord = coord.concat(", South");
					}
					coordText.setText(coord);
					break;
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_main);
		
		if (savedInstanceState != null) {
			regNo = Integer.parseInt(savedInstanceState.getString("regNo"));
		} else {
			regNo = 0;
		}
		
		TextView coordText = (TextView)PracticalTest01Var05MainActivity.this.findViewById(R.id.coord);
		coordText.setText("");
		
		Button navigateToSecondaryActivityButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
		navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);
		Button northButton = (Button)findViewById(R.id.north);
		northButton.setOnClickListener(buttonClickListener);
		Button westButton = (Button)findViewById(R.id.west);
		westButton.setOnClickListener(buttonClickListener);
		Button eastButton = (Button)findViewById(R.id.east);
		eastButton.setOnClickListener(buttonClickListener);
		Button southButton = (Button)findViewById(R.id.south);
		southButton.setOnClickListener(buttonClickListener);
	}

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putString("regNo", String.valueOf(regNo));
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if(resultCode == RESULT_OK){
			regNo++;
		}
		
		TextView coordText = (TextView)PracticalTest01Var05MainActivity.this.findViewById(R.id.coord);
		coordText.setText("");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var05_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
