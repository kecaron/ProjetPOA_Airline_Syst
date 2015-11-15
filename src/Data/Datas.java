package Data;

import Model.*;

import java.util.*;

/**
 * Created by caron on 14/11/15.
 */
public class Datas {

    //List of Airport
    // --> With that all class can access at the data and read / writte to it without create a new instance of another class than Datas.
    private static List<Airport> airportList = new ArrayList<Airport>();

    // List of Airline
    // --> With that all class can access at the data and read / writte to it without create a new instance of another class than Datas.
    private static List<Airline> airlineList = new LinkedList<Airline>();

    private static LinkedList <HashMap <FlightSection,LinkedList<Seat>>> listSeatbyClass = new LinkedList<HashMap <FlightSection,LinkedList<Seat>>>();

    private static HashMap <FlightSection,LinkedList<Seat>> FlsecSeatmap = new HashMap<FlightSection,LinkedList<Seat>>();

    private static List<String> AiportOrigDestmap = new ArrayList<String>();

    //Map of Flight --> Airline
    // --> With that all class can access at the data and read / writte to it without create a new instance of another class than Datas.
    private static Map<Flight, Airline> flightMap = new HashMap<Flight, Airline>();

    // Map of Flight ---> ( String of Origin Airport ----> String of Dest Airport)
    // --> With that all class can access at the data and read / writte to it without create a new instance of another class than Datas.
    private static HashMap<Flight,HashMap<String,String>> OrigDestFlIDMap = new HashMap<Flight,HashMap<String,String>>();

    //Map of Flight --> Section ---> Row ---> Col
    // --> With that all class can access at the data and read / writte to it without create a new instance of another class than Datas.
    private static Map<Flight,HashMap<FlightSection,LinkedList<Seat>>> flightSectionMap = new HashMap<Flight, HashMap<FlightSection, LinkedList<Seat>>>();

    public LinkedList<HashMap<FlightSection, LinkedList<Seat>>> getListSeatbyClass() {return listSeatbyClass;}
    public HashMap<FlightSection, LinkedList<Seat>> getFlsecSeatmap() {return FlsecSeatmap; }
    public List<String> getAiportOrigDestmap() {return AiportOrigDestmap; }
    public Map<Flight, HashMap<FlightSection, LinkedList<Seat>>> getFlightSectionMap() {return flightSectionMap;}
    public List<Airline> getAirlineList() {
        return airlineList;
    }
    public  List<Airport> getAirportList() {
        return airportList;
    }
    public Map<Flight, Airline> getFlightMap() {
        return flightMap;
    }
    public Map<Flight,HashMap<String,String>> getOrigDestMap() {
        return OrigDestFlIDMap;
    }
    public boolean ModifyBooked(Flight Fl,FlightSection s,LinkedList<Seat> list)
    {
        if(Fl==null || s==null || list==null )
        {
            return false;
        }
        //Going to good flight
        if(flightSectionMap.containsKey(Fl))
        {
            // we get the HashMap
            HashMap<FlightSection, LinkedList<Seat>> temp =flightSectionMap.get(Fl);
            //Going to good Section
            if(temp.containsKey(s))
            {
                //Suprress the key/Value
                temp.remove(s);
                //Put the new one.
                temp.put(s,list);
                return true;
            }
        }
        return false;
    }
}
