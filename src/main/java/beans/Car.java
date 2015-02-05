package beans;

import org.springframework.stereotype.Repository;

@Repository("Car")
public class Car extends Vehicle
{
    public Car(double averageConsumption, FuelType typeOfFuel, int cargo)
    {
        super(averageConsumption, typeOfFuel, cargo);
    }
}
