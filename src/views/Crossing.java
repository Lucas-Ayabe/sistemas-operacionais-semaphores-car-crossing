package views;

import java.util.concurrent.Semaphore;
import models.Car;
import models.Direction;

public class Crossing {

    public Crossing() {
        var semaphore = new Semaphore(1);
        var id = 1;

        for (var direction : Direction.values()) {
            (new Car(id, direction, semaphore)).start();
            id++;
        }
    }
}
