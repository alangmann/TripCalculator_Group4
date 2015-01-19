import beans.*;
import dal.DAL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TripCalculatorTest
{

    private TripCalculator calculator;
    LinkedList<Route> liste;
    @Before
    public void init() throws IOException {

        calculator = new TripCalculator();
        DAL d = new DAL();
        liste = d.getRoutes();

    }


    @Test
    public void testSimpleRoute()
    {
        assertThat(calculator.calculateTrip(new Route(10, 1.0005, RouteType.Highway, 0)), equalTo(1.3256625000000002));
    }

    @Test
    public void testSimpleRoute_TypeNull()
    {
        assertThat(calculator.calculateTrip(new Route(10, 1.0005,null, 0)), equalTo(1.3256625000000002));
    }

    @Test
    public void testCo2()
    {
        assertThat(calculator.calculateCo2Consumption(new Car(5, FuelType.Diesel, 100), liste.get(0)), equalTo(1.45822875));
    }

    @Test
    public void testCostofRoute()
    {
        assertThat(calculator.calculateTotalCostofRoute(liste.get(0), new Vehicle(35, FuelType.Diesel,20000),"Monday"), equalTo(31.256999999999998)); // Runden
    }


}