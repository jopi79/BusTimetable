package bustimetable.data;

import java.util.List;

import bustimetable.data.model.BusNumber;
import bustimetable.data.model.BusStop;
import bustimetable.data.model.Direction;

public interface DataProvider {
	List<BusNumber> getBusNumbers();
	
	List<Direction> getDirections(BusNumber busNumber);
	
	List<BusStop> getBusStops(BusNumber busNumber, Direction direction);
}
