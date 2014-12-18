import beans.Route;
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

    public void calculateTrip()
    {
        try
        {
            LinkedList<Route> routes = dal.getRoutes();
            for(Route r : routes)
            {
                double co2 = r.getDistance()*0.1325*r.getSlope()*r.getSpecialFee();
                System.out.println("Die Distanz:"+r.getDistance()+"km hat ein CO2 von:"+co2);
            }
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Fehler beim einlesen!");
        }
    }

    public static void main(String[] args)
    {
        TripCalculator calculator = new TripCalculator();
        calculator.calculateTrip();
    }
}