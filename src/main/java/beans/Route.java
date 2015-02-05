package beans;

import org.springframework.stereotype.Repository;

@Repository("Route")
public class Route
{
    private double distance;
    private double slope;
    private RouteType typeOfRoute;
    private double specialFee;

    public Route(double distance, double slope, RouteType typeOfRoute, double specialFee)
    {
        this.distance = distance;
        this.slope = slope;
        this.typeOfRoute = typeOfRoute;
        this.specialFee = specialFee;
    }

    public double getDistance()
    {
        return distance;
    }


    public RouteType getTypeOfRoute()
    {
        return typeOfRoute;
    }


    public double getSlope()
    {
        return slope;
    }


    public double getSpecialFee()
    {
        return specialFee;
    }


}
