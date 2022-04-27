package ColorBox.DevelopCartoon;

import ColorBox.Box.BoxTwoCap;
import ColorBox.DevelopPlastic.Inside;
import ColorBox.DevelopPlastic.PlasticTwoCap;
import ColorBox.Part.Board;
import ColorBox.Process.That;

import java.util.ArrayList;

public class DevelopTwoCap extends DevelopCap {
    private ArrayList<Board> listThree = new ArrayList<>();

    public void DevelopTwoCap(BoxTwoCap box, int number, int now, int plasticSelected) {
        That.list.add("Коробка типа \"Двойное дно\"\n");

        if (box.getF() != box.getZ()) {
            int a = (box.getZ() + 2) - box.getF();
            listThree.add(new Board(box.getX() + 4, a));
        }
        int b = (box.getZ() + 2) - (box.getG() + 2) - box.getH();

        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getX() + 4, box.getF() + 2));
        listTwo.add(new Board(box.getY(), box.getF() + 2));

        listTwo.add(new Board(box.getX() + 9, box.getY() + 9));
        listTwo.add(new Board(box.getX() + 9, box.getG()));
        listTwo.add(new Board(box.getY() + 5, box.getG()));
        listTwo.add(new Board(box.getX() + 9, b));
        listTwo.add(new Board(box.getY() + 5, b));


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
            That.list.add("На сторону " + slide +
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
            That.list.add("На сторону " + slide +
                    " требуется " + String.format("%.1f", aBack) + " л.");
        }

        for (Board slide : listThree) {                  //БОРТ
            int number4 = number * 2;
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
            That.list.add("Внутряняя вставка в крышку " + slide +
                    " требует " + String.format("%.1f", aBack) + " л.");
        }

        That.list.add(
                "Всего требуется " + String.format("%.1f", cartList)
                        + " л. картона на тираж" + System.lineSeparator()
        );

        if (now > 0) {
            Inside inside = new Inside();
            switch (now) {
                case 1:
                    That.list.add("Обкатка внутри, материал \"Oracal\"\n");
                    That.list.add(inside.roll(listOne, listTwo, number));
                    break;
                case 2:
                    That.list.add("Обкатка внутри, материал \"DLC 1.37 м.\"\n");
                    That.list.add(inside.rollDlc(listOne, listTwo, number));
                    break;
                case 3:
                    That.list.add("Обкатка внутри, материал \"DLC 1.5 м.\"\n");
                    That.list.add(inside.rollDlcPlus(listOne, listTwo, number));
                    break;
            }
        }

        PlasticTwoCap plasticTwoCap = new PlasticTwoCap();
        //ниже идет добавление текста!!!
        That.list.add(plasticTwoCap.Roll(box, number, plasticSelected, b));
    }
}
