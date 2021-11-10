package building;

import building.states.ElevatorState;
import building.states.RestState;

public class Elevator {
    private String id;
    private int currentFloor;
    private int numberOfFloors;
    private ElevatorState elevatorState;

    public Elevator(String id, int numberOfFloors, int currentFloor) {
        this.id = id;
        this.numberOfFloors = numberOfFloors;
        this.currentFloor = currentFloor;
        elevatorState = new RestState(this);
    }

    public String getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
