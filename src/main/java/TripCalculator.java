import beans.Route;
import beans.RouteType;
import dal.DAL;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by andreas.langmann on 12.11.2014.
 */
public class TripCalculator
{
    private DAL dal = new DAL();

    public TripCalculator()
    {
        dal = new DAL();
    }

    public void calculateTrip(Double km, double co2, double slope,  RouteType rt)
    {
        try
        {
            LinkedList<Route> routes = dal.getRoutes();

            if(km == null || km <= 0 || rt == null)
            {
                System.out.println("Eingabe ungueltig!");
            }
            else
            {
                if (RouteType.Highway == rt) {
                    System.out.println(km * co2 * slope * 1);
                }
                if (RouteType.CountryRoad == rt) {
                    System.out.println(km * co2 * slope * 1.2);
                }
                if (RouteType.GravelRoad == rt) {
                    System.out.println(km * co2 * slope * 2);
                }
            }

        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Fehler beim einlesen!");
        }
    }

    public static void main(String[] args)
    {
        TripCalculator calculator = new TripCalculator();
    }
}