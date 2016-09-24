package bustimetable.data.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bustimetable.data.DataProvider;
import bustimetable.data.model.BusNumber;
import bustimetable.data.model.BusStop;
import bustimetable.data.model.Direction;

public class MockDataProvider implements DataProvider {

	@Override
	public List<BusNumber> getBusNumbers() {
		List<BusNumber> result = new ArrayList();
		for(int i=1;i<22;i++) result.add(new BusNumber(""+i));
		return result;
	}

	@Override
	public List<Direction> getDirections(BusNumber busNumber) {
		return Arrays.asList(
				new Direction("Dworzec - pêtla ---> Al.Odrodzenia - pêtla"),
				new Direction("Al.Odrodzenia - pêtla ---> Dworzec - pêtla"));
		
	}

	@Override
	public List<BusStop> getBusStops(BusNumber busNumber, Direction direction) {
		// TODO Auto-generated method stub
		return null;
	}

}
