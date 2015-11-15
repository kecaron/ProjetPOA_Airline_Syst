package Factory;

import Data.Datas;
import Model.*;

/**
 * Created by caron on 13/11/15.
 */
public class SeatFactory {
    public Seat getSeat(int row,int col)
    {
        if( row==0 || col==0 || col>7)
        {
            return null;
        }
        else {
            // in case of an error.
            char p='*';
            switch (col) {
                case 1:
                    p = 'A';
                    break;
                case 2:
                    p = 'B';
                    break;
                case 3:
                    p = 'C';
                    break;
                case 4:
                    p = 'D';
                    break;
                case 5:
                    p = 'E';
                    break;
                case 6:
                    p = 'F';
                    break;
                case 7:
                    p = 'G';
                    break;
            }
            return new Seat(new SeatID(row,p),false);
        }
    }
}
