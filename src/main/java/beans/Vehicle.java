package beans;

public class Vehicle
{
    private double averageConsumption;
    private FuelType typeOfFuel;
    private int cargo;
    public Vehicle(double averageConsumption, FuelType typeOfFuel, int cargo)
    {
        this.averageConsumption = averageConsumption;
        this.typeOfFuel = typeOfFuel;
        this.cargo = cargo;
    }

    public double getAverageConsumption()
    {
        return averageConsumption;
    }

    public FuelType getTypeofFuel()
    {
        return typeOfFuel;
    }

    public int getCargo()
    {
        return cargo;
    }
}