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
				new Direction("Dworzec - p�tla ---> Al.Odrodzenia - p�tla"),
				new Direction("Al.Odrodzenia - p�tla ---> Dworzec - p�tla"));
		
	}

	@Override
	public List<BusStop> getBusStops(BusNumber busNumber, Direction direction) {
		return Arrays.asList(
				new BusStop("Dworzec - p�tla"),
				new BusStop("Grunwaldzka - hotel"),
				new BusStop("Mickiewicza"),
				new BusStop("Ko�ciuszki - Wsp�lna"),
				new BusStop("Ko�ciuszki - Toru�ska"),
				new BusStop("Kr�lewiecka - szpital"),
				new BusStop("Kr�lewiecka - Metalowc�w"),
				new BusStop("Fromborska - Truso")
				);
	}

}
