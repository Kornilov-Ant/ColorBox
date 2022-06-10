package ColorBox.Backend.DevelopCartoon;

import ColorBox.Backend.Box.BoxTwoCap;
import ColorBox.Backend.CreateService.CreateCartoon;
import ColorBox.Backend.DevelopPlastic.InsideTwoCap;
import ColorBox.Backend.DevelopPlastic.PlasticTwoCap;
import ColorBox.Backend.Part.Board;
import ColorBox.Frontend.Play;

import java.util.ArrayList;

public class DevelopTwoCap extends DevelopCap {
    private ArrayList<Board> listThree = new ArrayList<>();

    public void developTwoCap(BoxTwoCap box, int number, int now, int plasticSelected) {
        Play.list.add("Коробка типа \"Двойное дно, выровненные борта\"\n");

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
            aBack = new CreateCartoon().createCartoon(slide, number * 2);
            cartList += aBack;

            //ниже идет добавление текста!!!
            Play.list.add("Внутряняя вставка в крышку " + slide +
                    " требует " + String.format("%.1f", aBack) + " л.");
        }

        Play.list.add(
                "Всего требуется " + String.format("%.1f", cartList)
                        + " л. картона на тираж" + System.lineSeparator()
        );

        if (now > 0) {
            InsideTwoCap inside = new InsideTwoCap();
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

        PlasticTwoCap plasticTwoCap = new PlasticTwoCap();
        //ниже идет добавление текста!!!
        Play.list.add(plasticTwoCap.roll(box, number, plasticSelected, b));
    }
}
