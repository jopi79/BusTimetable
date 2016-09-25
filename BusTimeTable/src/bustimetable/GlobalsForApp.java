package bustimetable;

import android.app.Application;
import bustimetable.data.DataProvider;
import bustimetable.data.mock.MockDataProvider;

public class GlobalsForApp extends Application {

	private DataProvider dataProvider;
	
	
	public DataProvider getDataProvider() {
		return dataProvider;
	}


	@Override
	public void onCreate() {
		super.onCreate();
		dataProvider = new MockDataProvider();
	}

}
