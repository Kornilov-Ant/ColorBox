package ColorBox.Backend.DevelopCartoon;

import ColorBox.Backend.CreateService.CreateCartoon;
import ColorBox.Backend.DevelopPlastic.PlasticMagicV;
import ColorBox.Backend.Box.BoxMagic;
import ColorBox.Backend.DevelopPlastic.Inside;
import ColorBox.Backend.Part.Board;
import ColorBox.Frontend.Play;

import java.util.ArrayList;

public class DevelopMagicV extends DevelopCap {
    private ArrayList<Board> insideOne = new ArrayList<>();
    private ArrayList<Board> insideTwo = new ArrayList<>();

    public void developMagicV(BoxMagic box, int number, int now, int plasticSelected) {
        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getY() + 4, box.getZ() + 2));
        listTwo.add(new Board(box.getX(), box.getZ() + 2));
        listTwo.add(new Board(box.getY() + 10, box.getY() + 7));
        listOne.add(new Board(box.getY() + 10, box.getF()));
        listOne.add(new Board(box.getY() + 10, box.getZ() + 6));

        Play.list.add("Коробка типа \"Шкатулка вертикальная\"\n");

        for (Board slide : listOne) {
            aBack = new CreateCartoon().createCartoon(slide, number);
            cartList += aBack;

            //ниже идет добавление текста!!!
            Play.list.add("На сторону " + slide + " требуется " + aBack + " л.");
        }

        for (Board slide : listTwo) {
            aBack = new CreateCartoon().createCartoon(slide, number * 2);
            cartList += aBack;

            //ниже идет добавление текста!!!
            Play.list.add("На сторону " + slide + " требуется " + String.format("%.1f", aBack) + " л.");
        }

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

        PlasticMagicV magicV = new PlasticMagicV();
        Play.list.add(magicV.roll(box, number, plasticSelected));
    }
}