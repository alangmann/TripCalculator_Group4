import beans.*;
import dal.DAL;
import org.hamcrest.core.IsEqual;
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
    public void calculateTripSimple()
    {
        assertThat(calculator.calculateTrip(liste.get(0), new Vehicle(5, FuelType.Diesel, 100)),equalTo(13.255000000000003));
    }

    @Test
    public void testSimpleRoute_TypeNull()
    {
        assertThat(calculator.calculateTrip(new Route(10, 1.0005,null, 0), new Vehicle(5, FuelType.Diesel, 100)), equalTo(0.));
    }

    @Test
    public void calculateRouteTest_RouteNull()
    {
        assertThat(calculator.calculateTrip(null, new Vehicle(5, FuelType.Diesel, 100)), equalTo(0.));
    }


    @Test
    public void testCostofRouteDiesel()
    {
        assertThat(calculator.calculateTotalCostofRoute(liste.get(0), new Vehicle(35, FuelType.Diesel,20000),"Monday"), equalTo(31.256999999999998)); // Runden
    }

    @Test
    public void testCostofRoutePatrol()
    {
        assertThat(calculator.calculateTotalCostofRoute(liste.get(0), new Vehicle(35, FuelType.Patrol,20000),"Friday"), equalTo(31.464)); // Runden
    }

    @Test
    public void testCostofRoutePetrol()
    {
        assertThat(calculator.calculateTotalCostofRoute(liste.get(0), new Vehicle(35, FuelType.Patrol,20000),"Monday"), equalTo(31.8735));
    }

    @Test
    public void testCostRoute_FuelTypeNull()
    {
        assertThat(calculator.calculateTotalCostofRoute(liste.get(0), new Vehicle(35, null,20000),"Monday"), equalTo(null));
    }

    @Test
    public void testCostRoute_RouteNull()
    {
        assertThat(calculator.calculateTotalCostofRoute(null, new Vehicle(35, FuelType.Patrol,20000),"Monday"), equalTo(null));
    }

    @Test
    public void testCo2Car()
    {
        assertThat(calculator.calculateCo2Consumption( new Car(5, FuelType.Diesel,100),liste.get(0)), equalTo(14.582287500000003)); // Runden
    }

    @Test
    public void testCo2Null()
    {
        assertThat(calculator.calculateCo2Consumption(null,liste.get(0)), equalTo(null)); // Runden
    }



}