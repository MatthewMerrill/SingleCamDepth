package nasathing.singlecamdepth.android;

import java.util.logging.Level;
import java.util.logging.Logger;

import nasathing.singlecamdepth.api.OutputModule;
import android.app.Activity;

public class AndroidOutputModule implements OutputModule {
	
	private Activity activity;
	
	public AndroidOutputModule(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void logInfo(String info) {
		Logger.getLogger(activity.getApplicationContext().getString(R.string.app_name))
			.info(info);
	}

	@Override
	public void logDebug(String debug) {
		Logger.getLogger(activity.getApplicationContext().getString(R.string.app_name))
			.log(Level.FINE, debug);
	}

	@Override
	public void logWarning(String warning) {
		Logger.getLogger(activity.getApplicationContext().getString(R.string.app_name))
			.warning(warning);
	}

	@Override
	public void logError(String error) {
		Logger.getLogger(activity.getApplicationContext().getString(R.string.app_name))
			.log(Level.SEVERE, error);
	}

}
