
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
    public void test()
    {
        tc.calculateTrip(10, 0.1325, 1.0005, RouteType.CountryRoad);
    }
}
