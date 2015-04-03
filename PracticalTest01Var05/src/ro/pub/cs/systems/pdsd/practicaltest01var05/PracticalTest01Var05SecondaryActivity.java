package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class PracticalTest01Var05SecondaryActivity extends Activity {

	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	private class ButtonClickListener implements Button.OnClickListener {
		
		@Override
		public void onClick(View view) {
			switch(view.getId()) {
			case R.id.register_button:
				setResult(RESULT_OK, new Intent());
				finish();
				break;
			case R.id.cancel_button:
				setResult(RESULT_CANCELED, new Intent());
				finish();
				break;
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_secondary);
		
		TextView coordText = (TextView)findViewById(R.id.coord);
		TextView regNoText = (TextView)findViewById(R.id.coord_no);
		Intent intent = getIntent();
		
		if (intent != null) {
			String coord = intent.getStringExtra("coord");
			if (coord != null) {
				coordText.setText(coord);
			}
			String regNo = intent.getStringExtra("regNo");
			if (regNo != null) {
				regNoText.setText(regNo);
			}
		}
		
		Button buttonReg = (Button)findViewById(R.id.register_button);
		buttonReg.setOnClickListener(buttonClickListener);
		Button buttonCancel = (Button)findViewById(R.id.cancel_button);
		buttonCancel.setOnClickListener(buttonClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var05_secondary, menu);
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
