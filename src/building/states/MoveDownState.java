package building.states;

import building.Elevator;

public class MoveDownState extends ElevatorState {

    public MoveDownState(Elevator elevator) {
        super(elevator);
    }

    @Override
    public void down() {
        System.out.println("Already In Down Mode");
    }

    @Override
    public void up() {
        System.out.println("Cannot switch direction");
    }

    @Override
    public void rest() {
        elevator.setElevatorState(new RestState(elevator));
    }

    @Override
    public void stop() {
        elevator.setElevatorState(new StopState(elevator));
    }

    @Override
    public int distanceFromFloor(int floor) {
        if(floor > elevator.getCurrentFloor())
            return floor + elevator.getNumberOfFloors() - elevator.getCurrentFloor();
        return elevator.getCurrentFloor()-floor;
    }


}
