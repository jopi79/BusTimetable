package bustimetable;

import java.util.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import bustimetable.data.DataProvider;
import bustimetable.data.model.BusNumber;
import bustimetable.threads.AbstractThreadData;
import bustimetable.threads.BackgroundThread;
import pl.joannaj.bustimetable.R;

public class MainActivity extends Activity {

	private DataProvider dataProvider;
	
	private GridView gridView;
	private List<BusNumber> busNumbers = new ArrayList();
	private BusNumbersAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GlobalsForApp globalsForApp = (GlobalsForApp) getApplication();
		dataProvider = globalsForApp.getDataProvider();
		
		gridView = (GridView) findViewById(R.id.gridView);
		adapter = new BusNumbersAdapter(MainActivity.this,android.R.layout.simple_list_item_1, busNumbers);
		
		getData();
	}

	private void getData()
	{
		String message = getString(R.string.getting_bus_numbers);
		BackgroundThread<Void,List<BusNumber>> worker = new BackgroundThread<Void,List<BusNumber>>(
				this, new BusNumbersData(this), message);
		worker.execute();
	}
	private class BusNumbersData extends AbstractThreadData<Void, List<BusNumber>>
	{

		public BusNumbersData(Activity activity) {
			super(activity);
		}

		@Override
		public List<BusNumber> getResult(Void[] args) throws Exception {
			return dataProvider.getBusNumbers();
		}

		@Override
		public void afterExecuting(List<BusNumber> result) {
			busNumbers.addAll(result);
			adapter.notifyDataSetChanged();
		}
	
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
}
