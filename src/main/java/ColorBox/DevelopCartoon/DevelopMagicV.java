package ColorBox.DevelopCartoon;

import ColorBox.Box.BoxMagic;
import ColorBox.DevelopPlastic.Inside;
import ColorBox.DevelopPlastic.PlasticMagicV;
import ColorBox.Part.Board;
import ColorBox.Process.That;

import java.util.ArrayList;

public class DevelopMagicV extends DevelopCap {
    private ArrayList<Board> insideOne = new ArrayList<>();
    private ArrayList<Board> insideTwo = new ArrayList<>();

    public void DevelopMagicV(BoxMagic box, int number, boolean now) {
        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getY() + 4, box.getZ() + 2));
        listTwo.add(new Board(box.getX(), box.getZ() + 2));
        listTwo.add(new Board(box.getY() + 10, box.getY() + 7));
        listOne.add(new Board(box.getY() + 10, box.getF()));
        listOne.add(new Board(box.getY() + 10, box.getZ() + 6));

        for (Board slide : listOne) {
            aX = lux.getX() / (slide.x + 2);
            aY = lux.getY() / (slide.y + 2);
            aXy = Math.floor(aX) * Math.floor(aY);

            bX = lux.getX() / (slide.y + 2);
            bY = lux.getY() / (slide.x + 2);
            bXy = Math.floor(bX) * Math.floor(bY);

            if (aXy >= bXy) {
                back = aXy;
            } else {
                back = bXy;
            }

            double res = (number / back) % 1;

            if (res == 0.0) {
                res = 0.0;
            } else if (res > 0.0 && res <= 0.3) {
                res = 0.3;
            } else if (res > 0.3 && res < 0.6) {
                res = 0.6;
            } else if (res >= 0.6) {
                res = 1.0;
            }

            aBack = Math.floor(number / back) + res;
            cartList = cartList + aBack;
            That.list.add("На сторону " + slide + " требуется " + aBack + " л.");
        }

        for (Board slide : listTwo) {
            int number2 = number * 2;
            aX = lux.getX() / (slide.x + 2);
            aY = lux.getY() / (slide.y + 2);
            aXy = Math.floor(aX) * Math.floor(aY);

            bX = lux.getX() / (slide.y + 2);
            bY = lux.getY() / (slide.x + 2);
            bXy = Math.floor(bX) * Math.floor(bY);

            if (aXy >= bXy) {
                back = aXy;
            } else {
                back = bXy;
            }

            double res = (number / back) % 1;

            if (res == 0.0) {
                res = 0.0;
            } else if (res > 0.0 && res <= 0.3) {
                res = 0.3;
            } else if (res > 0.3 && res < 0.6) {
                res = 0.6;
            } else if (res >= 0.6) {
                res = 1.0;
            }

            aBack = Math.floor((number2) / back) + res;
            cartList = cartList + aBack;
            //ниже идет добавление текста!!!
            That.list.add("На сторону " + slide + " требуется " + String.format("%.1f", aBack) + " л.");
        }

        That.list.add("Всего требуется " + String.format("%.1f", cartList)
                + " л. картона на тираж" + System.lineSeparator());

        if (now) {
            insideOne.add(new Board(box.getX(), box.getY()));
            insideTwo.add(new Board(box.getX() + 4, box.getZ() + 2));
            insideTwo.add(new Board(box.getY(), box.getZ() + 2));
            Inside inside = new Inside();
            That.list.add(inside.roll(insideOne, insideTwo, number));
        }

        PlasticMagicV magicV = new PlasticMagicV();
        That.list.add(magicV.Roll(box, number));
    }
}