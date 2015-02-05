package dal;

import beans.Route;
import beans.RouteType;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Enis Lushtaku on 04.12.2014.
 */
@Repository("DAL")
public class DAL
{
    private String routesPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "routes.csv";
    private String sprit_dbPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "sprit_db.csv";

    public DAL()
    {
    }

    public LinkedList<Route> getRoutes() throws IOException
    {
        LinkedList<Route> routes = new LinkedList<Route>();

        BufferedReader br = new BufferedReader(new FileReader(routesPath));

        String line;
        br.readLine();

        while ((line = br.readLine()) != null)
        {
            String[] data = line.split(";");
            double distance = Double.parseDouble(data[0].replace(',', '.'));
            double slope = Double.parseDouble(data[1].replace(',', '.'));
            RouteType typeOfRoute = RouteType.valueOf(data[2]);
            double specialFee = Double.parseDouble(data[3].replace(',', '.'));
            Route route = new Route(distance, slope, typeOfRoute, specialFee);
            routes.add(route);
        }
        return routes;
    }

    public  ArrayList<Double> getSprit(String dayofweek) throws IOException
    {

        BufferedReader br = new BufferedReader(new FileReader(sprit_dbPath));
        String line;
        br.readLine();

        while ((line = br.readLine()) != null)
        {
            String data[] = line.split(";");
            String day = data[0];
            double diesel = Double.parseDouble(data[1].replace(',','.'));
            double petrol = Double.parseDouble(data[2].replace(',','.'));

            if(day.equals(dayofweek))
            {
                ArrayList<Double> liste = new ArrayList<Double>();
                liste.add(diesel);
                liste.add(petrol);
                return liste;
            }
        }

        return null;


    }





}
