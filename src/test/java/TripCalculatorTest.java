import beans.FuelType;
import beans.Route;
import beans.RouteType;
import beans.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TripCalculatorTest
{

    private TripCalculator calculator;

    @Test
    public void testSimpleRoute()
    {
        assertThat(calculator.calculateTrip(new Route(10, 1.0005, RouteType.Highway, 0)), equalTo(1.3256625));
    }

    @Test
    public void testSimpleRoute_TypeNull()
    {
        assertThat(calculator.calculateTrip(new Route(10, 1.0005,null, 0)), equalTo(1.3256625000000002));
    }

    @Test
    public void testCostofRoute()
    {
        assertThat(calculator.getCostsofTrip((new Route(10, 1.0005,RouteType.Highway, 5.0625)), new Vehicle(35/100, FuelType.Diesel, 20000)), equalTo(31.26));
    }
}