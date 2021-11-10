package building.states;

import building.Elevator;

public class RestState extends ElevatorState {

    public RestState(Elevator elevator) {
        super(elevator);
    }

    @Override
    public void down() {
        elevator.setElevatorState(new MoveDownState(elevator));
    }

    @Override
    public void up() {
        elevator.setElevatorState(new MoveUpState(elevator));
    }

    @Override
    public void rest() {
        System.out.println("Already in rest mode.");
    }

    @Override
    public void stop() {
        elevator.setElevatorState(new StopState(elevator));
    }

    @Override
    public int distanceFromFloor(int floor) {
        return Math.abs(floor - elevator.getCurrentFloor());
    }


}
