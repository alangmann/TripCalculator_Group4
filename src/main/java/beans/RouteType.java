package beans;

import org.springframework.stereotype.Repository;

@Repository("RouteType")
public enum RouteType
{
    Highway, CountryRoad, GravelRoad;
}
