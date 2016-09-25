package bustimetable;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;
import bustimetable.data.model.BusNumber;

public class BusNumbersAdapter extends ArrayAdapter<BusNumber> {

	public BusNumbersAdapter(Context context, int resource, List<BusNumber> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

}
