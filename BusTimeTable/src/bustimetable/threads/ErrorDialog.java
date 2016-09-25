package bustimetable.threads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import pl.joannaj.bustimetable.R;

public class ErrorDialog extends DialogFragment{

	private Exception exception;	
	private boolean finishActivity;
	
	public ErrorDialog(Exception exception) {
		super();
		this.exception = exception;
	}
	public ErrorDialog(Exception exception, boolean finishActivity) {
		super();
		this.exception = exception;
		this.finishActivity = finishActivity;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		String title = getActivity().getString(R.string.error_occurred);
		builder.setTitle(title);
		String message = exception.getLocalizedMessage();
		builder.setMessage(message);
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				onOkClick();
			}
		});		
		return builder.create();
	}
	
	public void onOkClick()
	{
		if(finishActivity)
		{
			this.getActivity().finish();
		}
	}
	
	public static void show(Exception e, Activity activity) {
		DialogFragment dialog = new ErrorDialog(e);
		dialog.show(activity.getFragmentManager(), "errordialog");
	}
}
