package ColorBox.DevelopPlastic;

import ColorBox.Box.BoxTwoCapLite;
import ColorBox.Part.Board;
import ColorBox.Part.Film;
import ColorBox.Process.Play;

import java.util.ArrayList;

public class InsideTwoCap extends Inside {
    private ArrayList<Board> listOne = new ArrayList<>();
    private ArrayList<Board> listTwo = new ArrayList<>();

    public String roll(BoxTwoCapLite box, int number) {
        int h = ((box.getZ() + 2) - box.getG()) / 2;

        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getX() + 4, box.getZ() + 2));
        listTwo.add(new Board(box.getY(), box.getZ() + 2));
        listOne.add(new Board(box.getX() + 9, box.getY() + 9));
        listTwo.add(new Board(box.getX() + 9, h));
        listTwo.add(new Board(box.getY() + 5, h));

        Play.list.add("Оклейка внутри:");
        for (Board a : listOne) {
            Film film = new Film(a.x, a.y);
            smallPlastic(film, number);
        }
        for (Board a : listTwo) {
            Film film = new Film(a.x, a.y);
            smallPlastic(film, number * 2);
        }

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);

        return "На обкатку рекомендуется 1,26х" + oracalBig.getY() +
                " м., 1х" + oracalSmall.getY() + " м. пленки."
                + System.lineSeparator() + "________________________________";
    }

    private void smallPlastic(Film filmDown, int number) {
        aD = Math.floor(oracalSmall.getZ() / filmDown.x);
        aU = Math.floor(oracalSmall.getX() / filmDown.y); // CONST

        bD = Math.floor(oracalSmall.getZ() / filmDown.y);
        bU = Math.floor(oracalSmall.getX() / filmDown.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (aU >= bU) {
            standart1 = (int) aU;
        } else {
            standart1 = (int) bU;
        }

        if (rollUp >= rollDown) {
            aD = number / Math.floor(oracalSmall.getX() / filmDown.y);
            rollOne = aD * filmDown.x;
        } else {
            bU = number / Math.floor(oracalSmall.getX() / filmDown.x);
            rollOne = bU * filmDown.y;
        }

        aD = Math.floor(oracalBig.getZ() / filmDown.x);
        aU = Math.floor(oracalBig.getX() / filmDown.y); // CONST

        bD = Math.floor(oracalBig.getZ() / filmDown.y);
        bU = Math.floor(oracalBig.getX() / filmDown.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (aU >= bU) {
            standart2 = (int) aU;
        } else {
            standart2 = (int) bU;
        }

        if (rollUp <= rollDown) {
            aD = number / Math.floor(oracalBig.getX() / filmDown.y);
            rollTwo = aD * filmDown.x;
        } else {
            bU = number / Math.floor(oracalBig.getX() / filmDown.x);
            rollTwo = bU * filmDown.y;
        }

        Double m22 = rollTwo * big;
        Double m21 = rollOne * small;

        Play.list.add("На часть " + filmDown + " получится:");
        Play.list.add("- рулон 1 м. шириной -> " + String.format("%.0f", m21)
                + " м2 (по " + standart1 + " шт. в ряд)");
        Play.list.add("- рулон 1,26 м. шириной -> " + String.format("%.0f", m22)
                + " м2 (по " + standart2 + " шт. в ряд)");

        if (m21 <= m22) {
            oracalSmall.setY(oracalSmall.getY() + (rollOne / oracalSmall.getX()));
        } else {
            oracalBig.setY(oracalBig.getY() + (rollTwo / oracalBig.getX()));
        }
    }
}
