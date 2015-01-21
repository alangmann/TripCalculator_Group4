import beans.*;
import dal.DAL;

import javax.swing.*;
import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.ArrayList;
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

    public double calculateTrip(Route r)
    {
        double co2 = 0.1325;
        if(r.getTypeOfRoute() == null)
        {
            return 0;
        }
        if(r.getSlope()==-5)
        {
            co2 = 0;
        }
        if (RouteType.Highway == r.getTypeOfRoute())
        {
            return (r.getDistance() *  co2 * r.getDistance()*1000+r.getSlope()/1000 * 1);
        }
        if (RouteType.CountryRoad == r.getTypeOfRoute())
        {
            return  (r.getDistance() *  co2 * r.getDistance()*1000+r.getSlope()/1000 * 1.2);
        }
        if (RouteType.GravelRoad == r.getTypeOfRoute())
        {
            return  (r.getDistance() *  co2 * r.getDistance()*1000+r.getSlope()/1000 * 2);
        }
        return 0;
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

    public Double calculateCo2Consumption(Vehicle v, Route r)
    {
        System.out.println(r.getSlope());
        double co2 = 0.1325;
        if(r.getTypeOfRoute() == null)
        {
            return 0.;
        }
        if(r.getSlope()==-5)
        {
            co2 = 0;
        }
        if (RouteType.Highway == r.getTypeOfRoute())
        {
            return ((r.getDistance() *  co2 * r.getDistance()*1000+r.getSlope()/1000) * 1);
        }
        if (RouteType.CountryRoad == r.getTypeOfRoute())
        {
            return  ((r.getDistance() *  co2 * r.getDistance()*1000+r.getSlope()/1000) * 1.2);
        }
        if (RouteType.GravelRoad == r.getTypeOfRoute())
        {
            return  ((r.getDistance() *  co2 * r.getDistance()*1000+r.getSlope()/1000) * 2);
        }
        return 0.;

    }

    public Double calculateTotalCostofRoute(Route r, Vehicle v, String dayofweek)
    {
        DAL d = new DAL();
        ArrayList<Double> preise = null;
        try
        {
             preise = d.getSprit(dayofweek);

        }
        catch (IOException e)
        {
            System.out.println("Fehler beim Auslesen der Preise!");

        }

        if(v.getTypeofFuel() == FuelType.Diesel)
        {
            double x = (v.getAverageConsumption()+v.getCargo()/100*r.getSlope()/100);
            return r.getDistance()*x/100*preise.get(0)+r.getSpecialFee()*5.0625;
        }
        if(v.getTypeofFuel() == FuelType.Patrol)
        {
            double x = (v.getAverageConsumption()+v.getCargo()/100*r.getSlope()/100);
            return r.getDistance()*x/100*preise.get(1)+r.getSpecialFee()*5.0625;
        }
        else
        {
            return null;
        }




    }




    public static void main(String[] args)
    {
        TripCalculator calculator = new TripCalculator();

    }
}