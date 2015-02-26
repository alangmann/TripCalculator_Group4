package calculator;

import beans.*;
import dal.DAL;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;

@Repository("calculator.TripCalculator")
public class TripCalculator
{
    final double CO2_CONSUMPTION_DIESEL = 0.0265;
    final double CO2_CONSUMPTION_PETROL = 0.0236;

    @Resource(name = "DAL")
    private DAL d;
    public double calculateTrip(Route r, Vehicle v)
    {
        if(r!=null) {
        double co2 = 0;
        if(v.getTypeofFuel() == FuelType.Diesel) {
            co2=CO2_CONSUMPTION_DIESEL * r.getSlope();
        }

        if(v.getTypeofFuel() == FuelType.Patrol) {
            co2=CO2_CONSUMPTION_PETROL * r.getSlope();
        }
            if (r.getTypeOfRoute() == null) {
                return 0;
            }
            if (r.getSlope() == -5) {
                co2 = 0;
            }
            if (RouteType.Highway == r.getTypeOfRoute()) {
                return (r.getDistance() * co2 * r.getDistance()  + r.getSlope() / 1000 * 1);
            }
            if (RouteType.CountryRoad == r.getTypeOfRoute()) {
                return (r.getDistance() * co2 * r.getDistance()  + r.getSlope() / 1000 * 1.2);
            }
            if (RouteType.GravelRoad == r.getTypeOfRoute()) {
                return (r.getDistance() * co2 * r.getDistance()  + r.getSlope() / 1000 * 2);
            }
            return 0;
        }
        else
        {
            return 0;
        }
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
        if(r!=null && v!=null)
        {
            if (getTypeOfVehicle(v).equals("Car"))
            {
                double co2 = 0;
                if(v.getTypeofFuel() == FuelType.Diesel) {
                    co2=CO2_CONSUMPTION_DIESEL * r.getSlope();
                }

                if(v.getTypeofFuel() == FuelType.Patrol) {
                    co2=CO2_CONSUMPTION_PETROL * r.getSlope();
                }

                double x = co2 + (co2/r.getDistance());
                if (RouteType.Highway == r.getTypeOfRoute())
                {
                    return (r.getDistance() * x * (r.getDistance()  + r.getSlope() / 1000) * 1);
                }
                if (RouteType.CountryRoad == r.getTypeOfRoute())
                {
                    return (r.getDistance() * x * (r.getDistance()  + r.getSlope() / 1000) * 1.2);
                }
                if (RouteType.GravelRoad == r.getTypeOfRoute())
                {
                    return (r.getDistance() * x * (r.getDistance()  + r.getSlope() / 1000) * 2);
                }
            }
            if (getTypeOfVehicle(v).equals("Truck"))
            {
                double co2 = 0;
                if(v.getTypeofFuel() == FuelType.Diesel) {
                    co2=CO2_CONSUMPTION_DIESEL * r.getSlope();
                }

                if(v.getTypeofFuel() == FuelType.Patrol) {
                    co2=CO2_CONSUMPTION_PETROL * r.getSlope();
                }

                double x = co2 + (co2/r.getDistance());
                if (RouteType.Highway == r.getTypeOfRoute()) {
                    return (r.getDistance() * x * (r.getDistance() * 1000 + r.getSlope() / 1000) * 1);
                }
                if (RouteType.CountryRoad == r.getTypeOfRoute()) {
                    return (r.getDistance() * x * (r.getDistance() * 1000 + r.getSlope() / 1000) * 1.2);
                }
                if (RouteType.GravelRoad == r.getTypeOfRoute()) {
                    return (r.getDistance() * x * (r.getDistance() * 1000 + r.getSlope() / 1000) * 2);
                }
            }

            else {
                return 0.;
            }
        }
        else
        {
            return null;
        }
        return null;

    }

    public Double calculateTotalCostOfRoute(Route r, Vehicle v, String dayofweek)
    {

        ArrayList<Double> preise = null;
        if(r!=null && v!=null && dayofweek!= null) {
            try {
                preise = d.getSprit(dayofweek);

            } catch (IOException e) {

                System.out.println("Fehler beim Auslesen der Preise!");
            }

            if (v.getTypeofFuel() == FuelType.Diesel) {
                double x = (v.getAverageConsumption() + v.getCargo() / 100 * r.getSlope() / 100);
                return r.getDistance() * x / 100 * preise.get(0) + r.getSpecialFee() * 5.0625;
            }
            if (v.getTypeofFuel() == FuelType.Patrol) {
                double x = (v.getAverageConsumption() + v.getCargo() / 100 * r.getSlope() / 100);
                return r.getDistance() * x / 100 * preise.get(1) + r.getSpecialFee() * 5.0625;
            } else {
                return null;
            }
        }
        else
        {
            return  null;
        }




    }


    public static void main(String[] args)
    {
        TripCalculator calculator = new TripCalculator();

    }
}