package Model;

import Data.Datas;
import Factory.FlightFactory;
import Factory.SectionFactory;

import java.util.*;

/**
 * Created by caron on 12/11/15.
 */
public class Airline {

    private String name;

    public Airline(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public Flight createFlight(String  orig,  String  dest,  Calendar  date,  String  id)
    {
        //Create a new flight with a factory
          return new FlightFactory().getFlight(date,this.name.concat(String.valueOf(id)),orig,dest);
    }
    public Flight findFlight(String flightID)
    {
        Object keyStore=null;
        Set key = new Datas().getFlightMap().keySet();
        Iterator ite = key.iterator();
        while (ite.hasNext()) {
            keyStore = ite.next();
            Flight p1 = (Flight)keyStore;
            if(p1.getId().equals(flightID))
            {
                return p1;
            }
        }
        return null;

    }
    public void createSection(String  flID, int rows,  int cols,  SeatClass s)
    {
        Flight p1;
        Map<Flight,Airline> temp = new Datas().getFlightMap();
        Set <Flight> key = temp.keySet();
        //we iterate the key of this map
        Iterator<Flight> ite = key.iterator();
        while (ite.hasNext()) {
            // We stack the Current key in p1 to be able to compare the value of the Key.
            p1 = ite.next();
            // if we got the same name we return the value of Key.
            if (p1.getId().equals(flID)) {
                new SectionFactory().getSection(p1,s,rows,cols);
                // Call of SeatFactory Within SectionFactory
            }
        }

    }/*
    public ArrayList<Flight> getAvailableFlights(Airport orig,  Airport dest)
    {

    }*/
    public void bookFlight(String fl, SeatClass s, int row, char col) {
        //Search the Flight
        Flight f1 = this.findFlight(fl);
        FlightSection fs1;
        SeatID send;
        boolean modify = false;
        LinkedList<Seat> list;
        LinkedList<Seat> Modifiedlist = null;
        // Search if the section exist in this flight return null if got nothing
        HashMap<FlightSection, LinkedList<Seat>> p1 = f1.findSection();
        if (p1 != null) {

            Set<FlightSection> key = p1.keySet();
            Iterator<FlightSection> ite = key.iterator();
            // we iterate the key to search if the section are the same
            while (ite.hasNext()) {
                fs1 = ite.next();
                if (fs1.getSeatClass().equals(s)) {
                    // if it's the case we get the Seat list of this Section
                    list = p1.get(s);
                    // we look if in this section we got the seat we search.
                    send = fs1.hasAvailableSeats(row, col, list);
                    if (send != null) {
                        // if its the case we change the statut in the list.
                        Modifiedlist = fs1.bookSeat(send, list);
                        modify = true;
                    }
                }

                if (modify) {
                    new Datas().ModifyBooked(f1, fs1, Modifiedlist);
                }
            }
        }
    }

    /*
    public void Call()
    {
        Object keyStore=null;
        System.out.println("La Liste des Compagnies aérienne : ");
        Set key = mapAirline.keySet();
        Iterator ite = key.iterator();
        while (ite.hasNext())
        {
            keyStore=ite.next();
            System.out.println("Compagnie :" +keyStore+ "----- vol : "+mapAirline.get(key)+'\n');
        }
    }*/
}
