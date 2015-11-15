package Vue;

import Data.Datas;
import Factory.AirlineFactory;
import Factory.AirportFactory;
import Model.Airline;
import Model.Flight;
import Model.SeatClass;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by caron on 12/11/15.
 */
public class SystemManager {
    private static SystemManager ourInstance = new SystemManager();

    public static SystemManager getInstance() {
        return ourInstance;
    }

    private SystemManager() {
    }

    public void CreateAirport(String name){
        new AirportFactory().getAirport(name);
    }
    public void createAirline(String name)
    {
        new AirlineFactory().getAirline(name);
    }
    public void createFlight(final String name,String orig,String dest,int year,int month,int day,String id)
    {
        List<Airline> temp = new Datas().getAirlineList();
        Iterator<Airline> ite = temp.iterator();
        Airline verif;
        boolean ok =false;
        while (ite.hasNext()) {
            verif = ite.next();
            if(ok)
            {
                break;
            }
            if (verif.getName().equalsIgnoreCase(name)) {
                Flight p1 = verif.createFlight(orig, dest, new GregorianCalendar(year, month, day), id);
                new Datas().getFlightMap().put(p1, verif);
                ok=true;
            }
        }
        if(!ok)
        {
            System.out.println("Flight non créer, aucune Compagnie de ce nom");
        }

    }
    public void createSection(String air, String flID, int  rows,  int  cols,  SeatClass s)
    {
        List<Airline> temp = new Datas().getAirlineList();
        Iterator<Airline> ite = temp.iterator();
        Airline verif;
        boolean ok =false;
        while (ite.hasNext()) {
            verif = ite.next();
            if(ok)
            {
                break;
            }
            if (verif.getName().equalsIgnoreCase(air)) {
                verif.createSection(air.concat(flID),rows,cols,s);
                ok=true;
            }
        }
        if(!ok)
        {
            System.out.println("Section non créer, aucune Compagnie de ce nom");
        }
    }/*
    public void findAvialableFlights(String orig,String dest)
    {
        // Appels a get AvaliableFLight
    }*/
    // Change here, we have to know what is the Seatclass we want to book.
    public void bookSeat(String airline,String idflight,SeatClass s,int row,char col)
    {
        List<Airline> temp = new Datas().getAirlineList();
        Iterator<Airline> ite = temp.iterator();
        Airline verif;
        boolean ok =false;
        while (ite.hasNext()) {
            verif = ite.next();
            if(ok)
            {
                break;
            }
            if (verif.getName().equalsIgnoreCase(airline)) {
                verif.bookFlight(idflight,s,row,col);
                ok=true;
            }
        }
        if(!ok)
        {
            System.out.println("Section non créer, aucune Compagnie de ce nom");
        }
    }/*
    public void displaySystemDetails()
    {
        //Afficher l'intégralité des objets
    }*/

}
