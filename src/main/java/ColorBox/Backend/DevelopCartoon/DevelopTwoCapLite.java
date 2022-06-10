package ColorBox.Backend.DevelopCartoon;

import ColorBox.Backend.Box.BoxTwoCapLite;
import ColorBox.Backend.CreateService.CreateCartoon;
import ColorBox.Backend.DevelopPlastic.Inside;
import ColorBox.Backend.DevelopPlastic.PlasticTwoCapLite;
import ColorBox.Backend.Part.Board;
import ColorBox.Frontend.Play;

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
            aBack = new CreateCartoon().createCartoon(slide, number);
            cartList += aBack;

            //ниже идет добавление текста!!!
            Play.list.add("На сторону " + slide +
                    " требуется " + aBack + " л.");
        }

        for (Board slide : listTwo) {
            aBack = new CreateCartoon().createCartoon(slide, number * 2);
            cartList += aBack;

            //ниже идет добавление текста!!!
            Play.list.add("На сторону " + slide +
                    " требуется " + String.format("%.1f", aBack) + " л.");
        }

        for (Board slide : listThree) {
            aBack = new CreateCartoon().createCartoon(slide, number * 4);
            cartList += aBack;

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
