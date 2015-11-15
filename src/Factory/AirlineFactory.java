package Factory;
import Data.Datas;
import Model.Airline;
import Model.Airport;

import java.util.Iterator;

/**
 * Created by caron on 13/11/15.
 */
public class AirlineFactory {

    //use getShape method to get object of type shape
    public Airline getAirline(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.length() >= 2 && shapeType.length() <= 5) {
                Airline p1 = new Airline(shapeType);
                new Datas().getAirlineList().add(p1);
                return p1;
            }
            return null;
        }

    }
