package building;

import building.dispatcher.Dispatcher;

import java.util.HashMap;
import java.util.Map;

public class Building {
    private int numberOfFloors;
    private Map<String, Elevator> elevators = new HashMap<>();
    Dispatcher dispatcher = Dispatcher.getInstance();

    public Building(int numberOfFloors, String... elevators) {
        this.numberOfFloors = numberOfFloors;
        for (String elevator : elevators) {
            String id = elevator.split(":")[0];
            int currentFloor = Integer.valueOf(elevator.split(":")[1]);
            Elevator e = new Elevator(id, numberOfFloors, currentFloor);
            this.elevators.put(e.getId(), e);
        }
        dispatcher.init(this.elevators);
    }

    public void move(String elevator_id, String direction) {
        Elevator e = elevators.get(elevator_id);
        switch (direction) {
            case "UP":
                e.getElevatorState().up();
                break;
            case "DOWN":
                e.getElevatorState().down();
                break;
        }

    }



    public String requestElevator() {
        return dispatcher.closedElevatorFromFloor(numberOfFloors);
    }

    public String requestElevator(int floor) {
        return dispatcher.closedElevatorFromFloor(floor);
    }

    public void stopAt(String elevatorId, int floor) {
        Elevator elevator = elevators.get(elevatorId);
        elevator.setCurrentFloor(floor);
        elevator.getElevatorState().stop();
    }

}
