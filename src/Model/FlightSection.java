package Model;

import Data.Datas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by caron on 12/11/15.
 */
public class FlightSection {
    private SeatClass section;
    private int row;
    private int col;
    public FlightSection(SeatClass section,int row,int col)
    {
        this.section=section;
        this.row=row;
        this.col=col;

    }
    public SeatClass getSeatClass()
    {
        return section;
    }
    public SeatID hasAvailableSeats(int row, char col,LinkedList<Seat> list)
    {
        LinkedList<Seat> p1 = new LinkedList<Seat>();
        p1.addAll(list);
        Seat temp;
        Iterator<Seat> ite = p1.iterator();
        while(ite.hasNext())
        {
            temp=ite.next();
            if(!temp.getisBooked())
            {
                if(temp.getSeatNum().getRow().equals(row) && temp.getSeatNum().getColumn().equals(col))
                {
                   return temp.getSeatNum();
                }
            }
        }
        return null;
        // on va chercher dans la section
        // on parcours la section
        // renvoie vrai dès que le premier siège est libre
    }

    public LinkedList<Seat> bookSeat(SeatID sId,LinkedList<Seat> list)
    {
        LinkedList<Seat> l1 = list;
        Iterator<Seat> ite =l1.iterator();
        Seat s1;
        while (ite.hasNext())
        {
            s1=ite.next();
            if(s1.getSeatNum().equals(sId))
            {
                s1.setIsBooked(true);
                return l1;
            }
        }

        return null;
    }
}
