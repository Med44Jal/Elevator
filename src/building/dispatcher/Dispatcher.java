package building.dispatcher;

import building.Elevator;

import java.util.Map;

/**
 * The dispatcher is responsible for deciding which elevator
 * has to serve the client in a giving floor
 */

public class Dispatcher implements Idispatcher {

    /**
     * Implementation of singleton pattern for Dispatcher class
     */
    public static Dispatcher _instance = null;
    private Map<String, Elevator> elevators;

    private Dispatcher() {
    }

    public static Dispatcher getInstance() {
        if (_instance == null)
            return new Dispatcher();
        return _instance;
    }


    public void init(Map<String, Elevator> elevatorsMap) {
        this.elevators = elevatorsMap;
    }


    public String closedElevatorFromFloor(int floor) {
        int dMinimale = 10;
        String idClosestElevator = "";
        for (String id : elevators.keySet()) {
            if (
                    elevators.get(id).getElevatorState().distanceFromFloor(floor) != -1 &&
                            elevators.get(id).getElevatorState().distanceFromFloor(floor) <= dMinimale) {
                dMinimale = elevators.get(id).getElevatorState().distanceFromFloor(floor);
                idClosestElevator = id;
            }
        }
        return idClosestElevator;
    }

    public Map<String, Elevator> getElevators() {
        return elevators;
    }

    public void setElevators(Map<String, Elevator> elevators) {
        this.elevators = elevators;
    }

}
