package beans;

import org.springframework.stereotype.Repository;

@Repository("Truck")
public class Truck extends Vehicle
{
    private int axles;
    private boolean adBlue;

    public Truck(double averageConsumption, FuelType typeOfFuel, int cargo, int axles, boolean adBlue)
    {
        super(averageConsumption, typeOfFuel, cargo);
        this.axles = axles;
        this.adBlue = adBlue;
    }

    public int getAxles()
    {
        return axles;
    }

    public void setAxles(int axles)
    {
        this.axles = axles;
    }

    public boolean isAdBlue()
    {
        return adBlue;
    }

    public void setAdBlue(boolean adBlue)
    {
        this.adBlue = adBlue;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        if (!super.equals(o)) return false;

        Truck truck = (Truck) o;

        if (adBlue != truck.adBlue) return false;
        if (axles != truck.axles) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + axles;
        result = 31 * result + (adBlue ? 1 : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Truck{" +
                "axles=" + axles +
                ", adBlue=" + adBlue +
                '}';
    }
}
