package building.states;

import building.Elevator;

public class StopState extends ElevatorState {

    public StopState(Elevator elevator) {
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
        elevator.setElevatorState(new RestState(elevator));
    }

    @Override
    public void stop() {
        System.out.println("Already In stop Mode");
    }

    @Override
    public int distanceFromFloor(int floor) {
        return -1;
    }


}
