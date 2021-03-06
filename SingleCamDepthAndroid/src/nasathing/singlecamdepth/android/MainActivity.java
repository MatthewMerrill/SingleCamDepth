package nasathing.singlecamdepth.android;

import nasathing.singlecamdepth.api.SingleCamDepth;
import android.app.Activity;
import android.hardware.camera2.CameraAccessException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	ImageView liveView;
	Spinner aperaturePositions;
	
	AndroidSingleCam asc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SingleCamDepth.out = new AndroidOutputModule(this);
		
		setContentView(R.layout.activity_main);
		
		liveView = (ImageView) this.findViewById(R.id.liveView);
		aperaturePositions = (Spinner) this.findViewById(R.id.spinnerAperature);
		
		asc = new AndroidSingleCam(this);
	}
	
	private void updateAperaturePositions() {
		float[] positions = asc.availableApertures();
		
		aperaturePositions.set
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	public void cameraOpened() {
		// TODO Auto-generated method stub
		
	}

	public void cameraClosed() {
		// TODO Auto-generated method stub
		
	}
}