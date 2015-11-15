package Model;

import Data.Datas;

import java.util.*;
/**
 * Created by caron on 12/11/15.
 */
public class Airport {
    private String code;


    public Airport(String code)
    {
        this.code=code;
    }
    public String getCode() {
        return code;
    }




    /*
    public void Call()
    {
        System.out.println("La Liste des Compagnies aérienne : ");
        Iterator <Airport> ite = listAirport.iterator();
        while (ite.hasNext())
        {
            System.out.println("Aéroport :"+ite.next().getCode()+'\n');
        }
    }*/

}
