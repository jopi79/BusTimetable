package bustimetable.threads;

import android.app.Activity;
import android.app.DialogFragment;

public abstract class AbstractThreadData<P,R> implements ThreadData<P,R>{

	private Activity activity;
	
	public AbstractThreadData(Activity activity)
	{
		this.activity = activity;
	}
	
	@Override
	public void showError(Exception e) {
		DialogFragment dialog = new ErrorDialog(e);
		dialog.show(activity.getFragmentManager(), "errordialog");
	}

	public Activity getActivity()
	{
		return activity;
	}
}
