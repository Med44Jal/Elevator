package building.states;

import building.Elevator;

public abstract class ElevatorState {
    protected Elevator elevator;

    public ElevatorState(Elevator elevator) {
        this.elevator = elevator;
    }

    public abstract void down();
    public abstract void up();
    public abstract void rest();
    public abstract void stop();
    public abstract int distanceFromFloor(int floor);


}
