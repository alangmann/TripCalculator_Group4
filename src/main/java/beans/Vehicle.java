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



    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (Double.compare(vehicle.averageConsumption, averageConsumption) != 0) return false;
        if (cargo != vehicle.cargo) return false;
        if (typeOfFuel != vehicle.typeOfFuel) return false;

        return true;
    }


}
