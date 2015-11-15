package Factory;

import Data.Datas;
import Model.Flight;
import Model.FlightSection;
import Model.Seat;
import Model.SeatClass;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by caron on 13/11/15.
 */
public class SectionFactory {
    public FlightSection getSection(Flight FlID,SeatClass s,int row,int col)
    {
        LinkedList <Seat> listSeat = new LinkedList<Seat>();
        HashMap <FlightSection,LinkedList<Seat>> temp = new HashMap<FlightSection,LinkedList<Seat>>();
        if(s==null || row==0 || col==0)
        {
            return null;
        }
        else
        {
          FlightSection p1 = new FlightSection(s,row,col);
            // Create all seats , add it in a linked List and put the list in the HashMap.
            for (int i=1;i<=row;i++){
                for (int j=1;j<=col;j++)
                {
                    Seat p2 = new SeatFactory().getSeat(i,j);
                    listSeat.add(p2);
                }
            }
            // put in the Map the association between this Flight Section and LinkedList Seat
            temp.put(p1,listSeat);
            new Datas().getListSeatbyClass().add(temp);
            // Put a Map an association between FlID & this Flight Section
            new Datas().getFlightSectionMap().put(FlID,temp);
            return p1;
        }
    }
}
