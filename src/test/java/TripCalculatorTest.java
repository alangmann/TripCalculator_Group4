import beans.*;
import calculator.TripCalculator;
import dal.DAL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.LinkedList;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


@ContextConfiguration(locations = "classpath:spring/spring-di-sample-annotation-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TripCalculatorTest
{
    @Resource(name = "DAL")
    DAL d;
    @Resource(name = "calculator.TripCalculator")
    private TripCalculator calculator;
    LinkedList<Route> liste;
    @Before
    public void init() throws IOException
    {
        liste = d.getRoutes();
    }


    @Test
    public void calculateTripSimpleDiesel()
    {
        assertThat(calculator.calculateTrip(liste.get(0), new Vehicle(5, FuelType.Diesel, 100)),equalTo(13.255000000000003));
    }

    @Test
    public void calculateTripSimplePatrol()
    {
        assertThat(calculator.calculateTrip(liste.get(0), new Vehicle(5, FuelType.Patrol, 100)),equalTo(11.805));
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
        assertThat(calculator.calculateTotalCostOfRoute(liste.get(0), new Vehicle(35, FuelType.Diesel,20000),"Monday"), equalTo(31.256999999999998)); // Runden
    }

    @Test
    public void testCostofRoutePatrol()
    {
        assertThat(calculator.calculateTotalCostOfRoute(liste.get(0), new Vehicle(35, FuelType.Patrol,20000),"Friday"), equalTo(31.464));
    }

    @Test
    public void testCostofRoutePetrol()
    {
        assertThat(calculator.calculateTotalCostOfRoute(liste.get(0), new Vehicle(35, FuelType.Patrol,20000),"Monday"), equalTo(31.8735));
    }

    @Test
    public void testCostRoute_FuelTypeNull()
    {
        assertThat(calculator.calculateTotalCostOfRoute(liste.get(0), new Vehicle(35, null,20000),"Monday"), equalTo(null));
    }

    @Test
    public void testCostRoute_WrongDay()
    {
        assertThat(calculator.calculateTotalCostOfRoute(liste.get(0), new Vehicle(35, null,20000),"XYZ"), equalTo(null));
    }

    @Test
    public void testCostRoute_DayNull()
    {
        assertThat(calculator.calculateTotalCostOfRoute(liste.get(0), new Vehicle(35, FuelType.Diesel,20000),null), equalTo(null));
    }

    @Test
    public void testCostRoute_RouteNull()
    {
        assertThat(calculator.calculateTotalCostOfRoute(null, new Vehicle(35, FuelType.Patrol,20000),"Monday"), equalTo(null));
    }

    @Test
    public void testCo2Car()
    {
        assertThat(calculator.calculateCo2Consumption( new Car(5, FuelType.Diesel,100),liste.get(0)), equalTo(14.582287500000003)); // Runden
    }


    @Test
    public void testCo2VehicleNull()
    {
        assertThat(calculator.calculateCo2Consumption(null,liste.get(0)), equalTo(null)); // Runden
    }

    @Test
    public void testCo2RouteNull()
    {
        assertThat(calculator.calculateCo2Consumption(new Car(5, FuelType.Diesel,100),null), equalTo(null)); // Runden
    }



}