package Model;

import Data.Datas;
import Model.Airline;
import Model.Airport;

import java.util.*;


/**
 * Created by caron on 12/11/15.
 */
public class Flight {
    private String flightID;
    private Calendar flightDate;

    public Flight(String flightID,Calendar flightDate)
    {
        this.flightID=flightID;
        this.flightDate=flightDate;
    }

    public Airline getAirline(String name) {
        Flight p1;
        Map<Flight,Airline> temp = new Datas().getFlightMap();
        Set <Flight> key = temp.keySet();
        //we iterate the key of this map
        Iterator<Flight> ite = key.iterator();
        while (ite.hasNext()) {
            // We stack the Current key in p1 to be able to return the value of the Key.
            p1 = ite.next();
            // if we got the same name we return the value of Key.
            if (p1.getId().equals(flightID)) {
                return temp.get(p1);
            }
        }
        return null;
    }

    public  String getId()
    {
        return flightID;
    }
    /*
    public Airport getOrig()
    {

    }

    public Airport getDest()
    {

    }
    */
    public Calendar getDate()
    {
        return flightDate;
    }/*


    */
    public HashMap<FlightSection,LinkedList<Seat>> findSection()
    {
        Map<Flight,HashMap<FlightSection,LinkedList<Seat>>> map = new Datas().getFlightSectionMap();
        HashMap<FlightSection,LinkedList<Seat>> map2;
        Set <Flight>key = map.keySet();
        Set <FlightSection>key2;
        Iterator<FlightSection> ite2;
        Flight f1;
        FlightSection fs1;
        Iterator<Flight> ite = key.iterator();
        while (ite.hasNext())
        {
            f1=ite.next();
            if(this.getId().equals(f1))
            {
                map2 =map.get(f1);
                if(map2.containsKey(SeatClass.BUSI) || map2.containsKey(SeatClass.FIRST) || map2.containsKey(SeatClass.ECO))
                {
                    return map2;
                }
            }
        }
        return null;

    }
}
