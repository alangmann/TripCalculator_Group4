import beans.*;
import dal.DAL;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by andreas.langmann on 12.11.2014.
 */
public class TripCalculator
{

    private DAL dal;

    public TripCalculator()
    {
        dal = new DAL();
    }

    public Double calculateTrip(Route r)
    {
        if(r.getTypeOfRoute()==null)
        {
            return null;
        }
        double co2 = 0.1325;
        if(r.getSlope()==-5)
        {
            co2 = 0;
        }
        if (RouteType.Highway == r.getTypeOfRoute())
        {
            return (Double)(r.getDistance() *  co2 * r.getSlope() * 1);
        }
        if (RouteType.CountryRoad == r.getTypeOfRoute())
        {
            return (Double)(r.getDistance() *  co2 * r.getSlope() * 1.2);
        }
        if (RouteType.GravelRoad == r.getTypeOfRoute())
        {
            return (Double)(r.getDistance() *  co2 * r.getSlope() * 2);
        }
        return null;
    }

    public String getTypeOfVehicle(Vehicle v)
    {
        if(v instanceof Car)
        {
            return "Car";
        }
        else if(v instanceof Truck)
        {
            return "Truck";
        }
        else
        {
            return null;
        }
    }

    public Double calculateConsideredTrip(Vehicle v, Route r)
    {
        double previousCalculation = calculateTrip(r);
        if(getTypeOfVehicle(v).equals("Car"))
        {
            return previousCalculation+0.5/100;
        }
        else
            return previousCalculation+0.05/100;
    }

    public Double getCostsofTrip(Route r, Vehicle v)
    {
        return r.getDistance() * (v.getAverageConsumption()+v.getCargo()/100*r.getSlope())/100 * 1.321 + r.getSpecialFee();
    }

    public static void main(String[] args)
    {
        TripCalculator calculator = new TripCalculator();
    }
}