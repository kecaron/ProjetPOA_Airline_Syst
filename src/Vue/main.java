package Vue;

import Model.Airline;
import Model.SeatClass;

/**
 * Created by caron on 12/11/15.
 */
public class main {
    public static void main (String[] args) {
        SystemManager p1 = SystemManager.getInstance();
        p1.CreateAirport("CDG");
        p1.CreateAirport("MAR");
        p1.CreateAirport("ORY");
        p1.CreateAirport("YUL");
        p1.CreateAirport("YYZ");
        p1.CreateAirport("NCE");

        p1.createAirline("AF");
        p1.createAirline("KLM");
        p1.createAirline("JAL");
        p1.createAirline("DELTA");
        p1.createFlight("AF", "CDG", "NCE", 2013, 11, 22, "7740");
        p1.createFlight("AF", "YUL", "CDG", 2013, 11, 23, "345");
        p1.createFlight("AF", "CDG", "YUL", 2013, 11, 24, "349");
        p1.createFlight("AF", "YYZ", "CDG", 2013, 9, 28, "37");
        p1.createSection("AF", "AF345", 5, 4, SeatClass.BUSI);
        p1.createSection("AF", "AF345", 15, 4, SeatClass.ECO);
        p1.createSection("AF", "AF7740", 15, 4, SeatClass.BUSI);
        p1.createSection("AF","AF7740",15,4, SeatClass.ECO);

    }
}
