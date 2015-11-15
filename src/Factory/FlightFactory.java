package Factory;
import Data.Datas;
import Model.Airline;
import Model.Airport;
import Model.Flight;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by caron on 13/11/15.
 */
public class FlightFactory {

    //use getShape method to get object of type shape

    public Flight getFlight(Calendar date,String  id,String orig,String dest){
        if(  date==null || id==null) {
            return null;
        }
        else
            {
                Flight p1 = new Flight(id, date);
                // To stock the Orig / Dest we create a HashMap from this
                 new Datas().getAiportOrigDestmap().add(orig);
                 new Datas().getAiportOrigDestmap().add(dest);
                HashMap<String,String> temp = new HashMap<String,String>();
                temp.put(orig,dest);
                // We put in a HashMap which Flight as Key the HashMap of Orig/Dest , like that we can search the Flight ID to retrieve the Orig/Dest
                //And if we don't know about FlightID we Had to just iterate all first map who got in the 2nd HashMap the Orig & Dest.
                new Datas().getOrigDestMap().put(p1,temp);
                return p1;

            }
    }
}