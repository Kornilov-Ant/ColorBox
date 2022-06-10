package ColorBox.Backend.DevelopPlastic;

import ColorBox.Backend.CreateService.CreatePlastic;
import ColorBox.Backend.Part.Board;
import ColorBox.Backend.Part.Film;
import ColorBox.Backend.Plastic.*;
import ColorBox.Frontend.Play;

import java.util.ArrayList;

public class Inside {
    protected Plastic oracalBig = new Plastic(1260);
    protected Plastic oracalSmall = new Plastic(1000);
    protected Plastic dlc = new Plastic(1370);
    protected Plastic dlcP = new Plastic(1500);
    protected double rollOne, rollTwo, rollDown, rollUp, aD, aU, bD, bU;
    protected double small = 1.00;
    protected double big = 1.26;
    protected double dlcD = 1.37;
    protected double dlcPlusD = 1.5;
    protected int standartOne;
    protected int standartTwo;

    public String rollDlcPlus(ArrayList<Board> listOne, ArrayList<Board> listTwo, int number) {
        Play.list.add("Оклейка внутри:");
        for (Board a : listOne) {
            Film film = new Film(a.x, a.y);
            dlcPlusPlastic(film, number);
        }
        for (Board a : listTwo) {
            Film film = new Film(a.x, a.y);
            dlcPlusPlastic(film, number * 2);
        }

        dlcP.setY(Math.round(dlcP.getY() * 100) / 100D);

        return "\n На обкатку рекомендуется 1,5х" + dlcP.getY() + " м. пленки."
                + System.lineSeparator() + "________________________________";
    }

    private void dlcPlusPlastic(Film filmDown, int number) {
        standartOne = (int) (new CreatePlastic().create(filmDown, number, dlcP)).get(0);
        rollOne = (double) (new CreatePlastic().create(filmDown, number, dlcP)).get(1);

        Play.list.add("На часть " + filmDown + " получится:");
        Play.list.add("- рулон 1,5 м. шириной -> " +
                String.format("%.0f", (rollOne * dlcPlusD))
                + " м2 (по " + standartOne + " шт. в ряд)");

        dlcP.setY(dlcP.getY() + (rollOne / dlcP.getX()));

    }

    public String rollDlc(ArrayList<Board> listOne, ArrayList<Board> listTwo, int number) {
        Play.list.add("Оклейка внутри:");
        for (Board a : listOne) {
            Film film = new Film(a.x, a.y);
            dlcPlastic(film, number);
        }
        for (Board a : listTwo) {
            Film film = new Film(a.x, a.y);
            dlcPlastic(film, number * 2);
        }

        dlc.setY(Math.round(dlc.getY() * 100) / 100D);

        return "\n На обкатку рекомендуется 1,37х" + dlc.getY() + " м. пленки."
                + System.lineSeparator() + "________________________________";
    }

    private void dlcPlastic(Film filmDown, int number) {
        standartOne = (int) (new CreatePlastic().create(filmDown, number, dlc)).get(0);
        rollOne = (double) (new CreatePlastic().create(filmDown, number, dlc)).get(1);

        Play.list.add("На часть " + filmDown + " получится:");
        Play.list.add("- рулон 1,37 м. шириной -> " +
                String.format("%.0f", (rollOne * dlcD))
                + " м2 (по " + standartOne + " шт. в ряд)");

        dlc.setY(dlc.getY() + (rollOne / dlc.getX()));

    }

    public String roll(ArrayList<Board> listOne, ArrayList<Board> listTwo, int number) {
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

        return "\n На обкатку рекомендуется 1,26х" + oracalBig.getY() +
                " м., 1х" + oracalSmall.getY() + " м. пленки."
                + System.lineSeparator() + "________________________________";
    }

    protected void smallPlastic(Film filmDown, int number) {
        standartOne = (int) (new CreatePlastic().create(filmDown, number, oracalSmall)).get(0);
        rollOne = (double) (new CreatePlastic().create(filmDown, number, oracalSmall)).get(1);

        standartTwo = (int) (new CreatePlastic().create(filmDown, number, oracalSmall)).get(0);
        rollTwo = (double) (new CreatePlastic().create(filmDown, number, oracalSmall)).get(1);

        Double m22 = rollTwo * big;
        Double m21 = rollOne * small;

        Play.list.add("На часть " + filmDown + " получится:");
        Play.list.add("- рулон 1 м. шириной -> " + String.format("%.0f", m21)
                + " м2 (по " + standartOne + " шт. в ряд)");
        Play.list.add("- рулон 1,26 м. шириной -> " + String.format("%.0f", m22)
                + " м2 (по " + standartTwo + " шт. в ряд)");

        if (m21 <= m22) {
            oracalSmall.setY(oracalSmall.getY() + (rollOne / oracalSmall.getX()));
        } else {
            oracalBig.setY(oracalBig.getY() + (rollTwo / oracalBig.getX()));
        }
    }
}
