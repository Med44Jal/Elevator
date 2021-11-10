package building.states;

import building.Elevator;

public class MoveUpState extends ElevatorState {

    public MoveUpState(Elevator elevator) {
        super(elevator);
    }

    @Override
    public void down() {
        System.out.println("Cannot switch direction");
    }

    @Override
    public void up() {
        System.out.println("Already In Up Mode");
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
        if(floor>=elevator.getCurrentFloor())
            return floor-elevator.getCurrentFloor();
        return floor + elevator.getNumberOfFloors() - elevator.getCurrentFloor();
    }


}
