package ColorBox.DevelopCartoon;

import ColorBox.Box.BoxTwoCap;
import ColorBox.Part.Board;
import ColorBox.Process.That;

public class DevelopTwoCap extends DevelopCap {

    public void DevelopTwoCap (BoxTwoCap box, int number){
        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getX()+4, box.getZ()+2));
        listTwo.add(new Board(box.getY(), box.getZ()+2));
        listTwo.add(new Board(box.getX()+9, box.getY()+9));
        listTwo.add(new Board(box.getX()+9, box.getG()));
        listTwo.add(new Board(box.getY()+5, box.getG()));
        listTwo.add(new Board(box.getX()+9, box.getF()));
        listTwo.add(new Board(box.getY()+5, box.getF()));

        for (Board slide: listOne){
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

            aBack = Math.ceil(number / back);
            cartList = cartList + (int)aBack;
            //ниже идет добавление текста!!!
            That.list.add("На сторону " + slide + " требуется " + (int)aBack + "л.");
        }

        for (Board slide: listTwo){
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

            aBack = Math.ceil((number * 2) / back);
            cartList = cartList + (int)aBack;
            //ниже идет добавление текста!!!
            That.list.add("На сторону " + slide + " требуется " + (int)aBack + "л.");
        }

    }

}
