package models;

import java.util.concurrent.Semaphore;

public class Car extends Thread {

    private int id;
    private Direction direction;
    private Semaphore semaphore;

    public Car(int id, Direction direction, Semaphore semaphore) {
        this.id = id;
        this.direction = direction;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(this + " está vindo" + direction());
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            interrupt();
        } finally {
            semaphore.release();
        }
    }

    private String direction() {
        switch (direction) {
            case TOP_TO_BOTTOM:
                return "de cima para baixo";
            case BOTTOM_TO_TOP:
                return "de baixo para cima";
            case LEFT_TO_RIGHT:
                return "da esquerda para direita";
            case RIGHT_TO_LEFT:
                return "da direita para esquerda";
            default:
                return "de um sentido desconhecido";
        }
    }

    @Override
    public String toString() {
        return "Car #" + id;
    }
}
