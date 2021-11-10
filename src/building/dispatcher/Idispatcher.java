package building.dispatcher;

import java.util.Map;

import building.Elevator;

public interface Idispatcher {
	
	public String closedElevatorFromFloor(int floor);
	public void init(Map<String, Elevator> elevatorsMap);

}
