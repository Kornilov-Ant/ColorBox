package ColorBox.Backend.DevelopCartoon;

import ColorBox.Backend.CreateService.CreateCartoon;
import ColorBox.Backend.DevelopPlastic.Inside;
import ColorBox.Frontend.*;
import ColorBox.Backend.Box.BoxCap;
import ColorBox.Backend.DevelopPlastic.PlasticCap;
import ColorBox.Backend.Part.Board;

import java.util.ArrayList;

public class DevelopCap {
    protected ArrayList<Board> listOne = new ArrayList<>();
    protected ArrayList<Board> listTwo = new ArrayList<>();
    protected double cartList;
    protected double aBack;

    public void developCap(BoxCap box, int number, int now, int plasticSelected) {
        listOne.add(new Board(box.getX() + 4, box.getY() + 4));
        listTwo.add(new Board(box.getX() + 4, box.getZ()));
        listTwo.add(new Board(box.getY(), box.getZ()));
        listOne.add(new Board(box.getX() + 9, box.getY() + 9));
        listTwo.add(new Board(box.getX() + 9, box.getF()));
        listTwo.add(new Board(box.getY() + 5, box.getF()));

        Play.list.add("Коробка типа \"Крышка-дно\"\n");

        for (Board slide : listOne) {
            aBack = new CreateCartoon().createCartoon(slide, number);
            cartList += aBack;

            //ниже идет добавление текста!!!
            Play.list.add("На сторону " + slide + " требуется " + String.format("%.1f", aBack) + " л.");
        }

        for (Board slide : listTwo) {
            aBack = new CreateCartoon().createCartoon(slide, number * 2);
            cartList += aBack;

            //ниже идет добавление текста!!!
            Play.list.add("На сторону " + slide + " требуется " + String.format("%.1f", aBack) + " л.");
        }

        //ниже идет добавление текста!!!
        Play.list.add("Всего требуется " + String.format("%.1f", cartList)
                + " л. картона на тираж" + System.lineSeparator());


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

        PlasticCap plasticCap = new PlasticCap();
        //ниже идет добавление текста!!!
        Play.list.add(plasticCap.roll(box, number, plasticSelected));
    }
}
