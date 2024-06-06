package org.model.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private List<Car> cars = new ArrayList<>();

    public CarService() {
        // Adding some sample data
        cars.add(new Car("Toyota", "ST23", "Red", true, true, true, true));
        cars.add(new Car("Toyota", "ST20", "Blue", false, true, false, false));
    }

    public Car getCarByModel(String model) {
        for (Car car : cars) {
            if (car.getType().equalsIgnoreCase(model)) {
                return car;
            }
        }
        return null; // Return null if no car is found
    }
}