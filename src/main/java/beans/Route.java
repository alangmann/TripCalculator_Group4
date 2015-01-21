package beans;

/**
 * Created by Enis Lushtaku on 04.12.2014.
 */
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


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;

        Route route = (Route) o;

        if (Double.compare(route.distance, distance) != 0) return false;
        if (Double.compare(route.slope, slope) != 0) return false;
        if (Double.compare(route.specialFee, specialFee) != 0) return false;
        if (typeOfRoute != route.typeOfRoute) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        temp = Double.doubleToLongBits(distance);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (typeOfRoute != null ? typeOfRoute.hashCode() : 0);
        temp = Double.doubleToLongBits(slope);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(specialFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString()
    {
        return "Route{" +
                "distance=" + distance +
                ", typeOfRoute=" + typeOfRoute +
                ", slope=" + slope +
                ", specialFee=" + specialFee +
                '}';
    }
}
