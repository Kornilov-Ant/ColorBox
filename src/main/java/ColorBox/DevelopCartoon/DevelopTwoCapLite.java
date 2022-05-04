package ColorBox.DevelopCartoon;

import ColorBox.Box.BoxTwoCapLite;
import ColorBox.DevelopPlastic.Inside;
import ColorBox.DevelopPlastic.PlasticTwoCapLite;
import ColorBox.Part.Board;
import ColorBox.Process.Play;

import java.util.ArrayList;

public class DevelopTwoCapLite extends DevelopCap {
    private ArrayList<Board> listThree = new ArrayList<>();

    public void developTwoCap(BoxTwoCapLite box, int number, int now, int plasticSelected) {
        int h = ((box.getZ() + 2) - box.getG()) / 2;

        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getX() + 4, box.getZ() + 2));
        listTwo.add(new Board(box.getY(), box.getZ() + 2));
        listTwo.add(new Board(box.getX() + 9, box.getY() + 9));
        listThree.add(new Board(box.getX() + 9, h));
        listThree.add(new Board(box.getY() + 5, h));

        Play.list.add("Коробка типа \"Двойное дно, разные борта\"\n");

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
            Play.list.add("На сторону " + slide +
                    " требуется " + aBack + " л.");
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
            Play.list.add("На сторону " + slide +
                    " требуется " + String.format("%.1f", aBack) + " л.");
        }

        for (Board slide : listThree) {                  //БОРТ
            int number4 = number * 4;
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

            aBack = Math.floor((number4) / back) + res;
            cartList = cartList + aBack;
            //ниже идет добавление текста!!!
            Play.list.add("На сторону " + slide +
                    " требуется " + String.format("%.1f", aBack) + " л.");
        }

        Play.list.add(
                "Всего требуется " + String.format("%.1f", cartList)
                        + " л. картона на тираж" + System.lineSeparator()
        );

        if (now > 0) {
            Inside inside = new Inside();
            switch (now) {
                case 1:
                    Play.list.add("Обкатка внутри, материал \"Oracal\"\n");
                    Play.list.add(inside.roll(listOne, listTwo, number));
                    break;
                case 2:
                    Play.list.add("Обкатка внутри, материал \"DLC 1.37 м.\"\n");
                    Play.list.add(inside.rollDlc(listOne, listTwo, number));
                    break;
                case 3:
                    Play.list.add("Обкатка внутри, материал \"DLC 1.5 м.\"\n");
                    Play.list.add(inside.rollDlcPlus(listOne, listTwo, number));
                    break;
            }
        }

        PlasticTwoCapLite plasticTwoCapLite = new PlasticTwoCapLite();
        //ниже идет добавление текста!!!
        Play.list.add(plasticTwoCapLite.roll(box, number, plasticSelected));
    }
}
