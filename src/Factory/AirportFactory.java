package Factory;
import Data.Datas;
import Model.Airport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by caron on 13/11/15.
 */
public class AirportFactory{
    //use getShape method to get object of type shape
    public Airport getAirport(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.length()==3){
            Airport p1 = new Airport(shapeType);
            new Datas().getAirportList().add(p1);
            return p1;
        }

        return null;
    }
}