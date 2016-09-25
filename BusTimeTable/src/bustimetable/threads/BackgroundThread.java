package bustimetable.threads;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

public class BackgroundThread<P,R> extends AsyncTask<P, Void, R>
{
	private Activity context;
	private ProgressDialog dialog;
	private Exception exception;
	private CharSequence message;
	private ThreadData<P,R> data;

	public BackgroundThread(Activity context, ThreadData<P,R> data, String message)
	{
		this.context = context;
		this.data = data;
		this.message = message;
		dialog = new ProgressDialog(context);
	}

	@Override
	protected R doInBackground(P... args)
	{
		try
		{
			R result = data.getResult(args);
			return result;
		} catch (Exception e)
		{
			exception = e;
			Log.e(this.getClass().getName(),e.getMessage(),e);
			return null;
		}

	}

	@Override
	protected void onPreExecute()
	{
		dialog.setMessage(message);
		dialog.show();
	}

	@Override
	protected void onPostExecute(R result)
	{
		if (context != null)
		{
			if (dialog.isShowing())
			{
				dialog.dismiss();
			}
			if(exception!=null)
			{
				data.showError(exception);
			}
			else
			{
				data.afterExecuting(result);
			}
		}
	}

	public void disconnectContext()
	{
		this.context = null;
	}

	public void connectContext(Activity context)
	{
		this.context = context;
	}

}
