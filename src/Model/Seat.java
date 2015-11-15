package Model;

/**
 * Created by caron on 12/11/15.
 */
public class Seat {
    private SeatID seatNum;
    private boolean isBooked;

    public Seat(SeatID seatNum,boolean isBooked)
    {
        this.seatNum=seatNum;
        this.isBooked=isBooked;
    }

    public SeatID getSeatNum()
    {
        return seatNum;
    }

    public boolean getisBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
}


