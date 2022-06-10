package ColorBox.Backend.CreateService;

import ColorBox.Backend.Part.Film;
import ColorBox.Backend.Plastic.*;

import java.util.ArrayList;
import java.util.List;

public class CreatePlastic {
    private double rollDown, rollUp, aD, aU, bD, bU;

//    public double create(Film film, int number, Plastic plastic){
//        aD = Math.floor(plastic.getZ() / film.x);
//        aU = Math.floor(plastic.getX() / film.y); // CONST
//
//        bD = Math.floor(plastic.getZ() / film.y);
//        bU = Math.floor(plastic.getX() / film.x); // CONST
//
//        rollUp = aD * aU;
//        rollDown = bD * bU;
//
//        if (aU >= bU) {
//            standartOne = (int) aU;
//        } else {
//            standartOne = (int) bU;
//        }
//
//        if (rollUp >= rollDown) {
//            aD = number / Math.floor(plastic.getX() / film.y);
//            return aD * film.x;
//        } else {
//            bU = number / Math.floor(plastic.getX() / film.x);
//            return bU * film.y;
//        }
//    }

    public List<Number> create(Film film, int number, Plastic plastic){
        List<Number> list = new ArrayList<>();
        aD = Math.floor(plastic.getZ() / film.x);
        aU = Math.floor(plastic.getX() / film.y); // CONST

        bD = Math.floor(plastic.getZ() / film.y);
        bU = Math.floor(plastic.getX() / film.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (aU >= bU) {
            list.add((int) aU);
        } else {
            list.add((int) bU);
        }


        if (rollUp >= rollDown) {
            aD = number / Math.floor(plastic.getX() / film.y);
            list.add(aD * film.x);
        } else {
            bU = number / Math.floor(plastic.getX() / film.x);
            list.add(bU * film.y);
        }
        return list;
    }
}
