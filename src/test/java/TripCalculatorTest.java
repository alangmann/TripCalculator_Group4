
import beans.RouteType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TripCalculatorTest
{
    TripCalculator tc;
    @Before
    public void init()
    {
        tc  = new TripCalculator();
    }

    @Test
    public void testCountryRoad()
    {
        tc.calculateTrip(10.0, 0.1325, 1.0005, RouteType.CountryRoad);
    }

    @Test
    public void testHighway()
    {
        tc.calculateTrip(4.0,0.1325, 1.69, RouteType.Highway);
    }

    @Test
    public void testGravelRoad()
    {
        tc.calculateTrip(10.0, 0.1325, 1.0005, RouteType.GravelRoad);
    }

    @Test
    public void testKmNull()
    {
        tc.calculateTrip(null, 0.1325, 1.0005, RouteType.GravelRoad);
    }

    @Test
    public  void testNoRouteType()
    {
        tc.calculateTrip(4.4, 0.1325, 1.0005, null);
    }
}
