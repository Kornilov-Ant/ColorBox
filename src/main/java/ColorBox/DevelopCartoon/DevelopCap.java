package ColorBox.DevelopCartoon;

import ColorBox.DevelopPlastic.Inside;
import ColorBox.Process.*;
import ColorBox.Box.BoxCap;
import ColorBox.Cartoon.Lux;
import ColorBox.DevelopPlastic.PlasticCap;
import ColorBox.Part.Board;

import java.util.ArrayList;

public class DevelopCap {
    protected ArrayList<Board> listOne = new ArrayList<>();
    protected ArrayList<Board> listTwo = new ArrayList<>();
    protected double cartList;
    protected double aX, aY, aXy, bX, bY, bXy, back, aBack;
    protected Lux lux = new Lux();

    public void DevelopCap(BoxCap box, int number, boolean now){
        listOne.add(new Board(box.getX()+4, box.getY()+4));
        listTwo.add(new Board(box.getX()+4, box.getZ()));
        listTwo.add(new Board(box.getY(), box.getZ()));
        listOne.add(new Board(box.getX()+9, box.getY()+9));
        listTwo.add(new Board(box.getX()+9, box.getF()));
        listTwo.add(new Board(box.getY()+5, box.getF()));

        for (Board slide: listOne){                 //КРЫШКА
            aX = lux.getX() / (slide.x+2);
            aY = lux.getY() / (slide.y+2);
            aXy=Math.floor(aX)*Math.floor(aY);

            bX = lux.getX() / (slide.y+2);
            bY = lux.getY() / (slide.x+2);
            bXy=Math.floor(bX)*Math.floor(bY);

            if (aXy>=bXy){
                back=aXy;
            } else {
                back=bXy;
            }

            double res = (number/back)%1;

            if (res==0.0){
                res = 0.0;
            } else if (res>0.0 && res<=0.3){
                res=0.3;
            } else if (res>0.3 && res < 0.6){
                res=0.6;
            } else if (res>=0.6){
                res=1.0;
            }

            aBack = Math.floor(number / back)+res;
            cartList = cartList + aBack;
            //ниже идет добавление текста!!!
            That.list.add("На сторону " + slide + " требуется " + String.format("%.1f", aBack) + " л.");
        }

        for (Board slide: listTwo){                  //БОРТ
            int number2 = number*2;
            aX = lux.getX() / (slide.x+2);
            aY = lux.getY() / (slide.y+2);
            aXy=Math.floor(aX)*Math.floor(aY);

            bX = lux.getX() / (slide.y+2);
            bY = lux.getY() / (slide.x+2);
            bXy=Math.floor(bX)*Math.floor(bY);

            if (aXy>=bXy){
                back=aXy;
            } else {
                back=bXy;
            }

            double res = ((number2)/back)%1;

            if (res==0.0){
                res = 0.0;
            } else if (res>0.0 && res<=0.3){
                res=0.3;
            } else if (res>0.3 && res < 0.6){
                res=0.6;
            } else if (res>=0.6){
                res=1.0;
            }

            aBack = Math.floor((number2) / back)+res;
            cartList = cartList + aBack;
            //ниже идет добавление текста!!!
            That.list.add("На сторону " + slide + " требуется " + String.format("%.1f", aBack) + " л.");
        }

        //ниже идет добавление текста!!!
        That.list.add("Всего требуется " + String.format("%.1f", cartList)
                + " л. картона на тираж" + System.lineSeparator());
        if (now){
            Inside inside = new Inside();
            That.list.add(inside.Roll(listOne, listTwo, number));
        }
        PlasticCap plasticCap = new PlasticCap();
        //ниже идет добавление текста!!!
        That.list.add(plasticCap.Roll(box, number));
    }
}
