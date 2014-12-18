import beans.Route;
import beans.RouteType;
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
}