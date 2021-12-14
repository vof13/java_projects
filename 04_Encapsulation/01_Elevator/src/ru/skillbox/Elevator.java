package ru.skillbox;

public class Elevator {
    int currentFloor = 1;
    int minFloor;
    int maxFloor;

    public Elevator ( int minFloor, int maxFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    private int getCurrentFloor () {
        return currentFloor;
    }

    private void moveDown () {
        currentFloor --;
    }

    private void moveUp () {
        currentFloor ++;
    }


    public void move (int floor) {
        int iter = Math.abs(floor-currentFloor);
        if (floor >= minFloor && floor <=maxFloor && floor != currentFloor) {
            for (int i = 0; i < iter; i++) {
                if ((floor > currentFloor)) {
                    moveUp();
                } else {
                    moveDown();
                }
                System.out.println("Текущий этаж: " + getCurrentFloor());
            }
        } else {
            System.out.println("Этаж введён не верно!");
        }
    }

}

