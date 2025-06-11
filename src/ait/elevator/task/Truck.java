package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private int nRaces;
    private int capacity;
    private Elevator elevator;

    public Truck(int nRaces, int capacity, Elevator elevator) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            synchronized (elevator) {     // синхронизируем процесс
                elevator.add(capacity);
            }
        }
    }
}
