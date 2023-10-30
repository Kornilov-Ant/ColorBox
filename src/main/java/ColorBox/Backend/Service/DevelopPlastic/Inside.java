package ColorBox.Backend.Service.DevelopPlastic;

import ColorBox.Backend.Entity.Plastic.Plastic;
import ColorBox.Backend.Service.CreateService.CreatePlastic;
import ColorBox.Backend.Entity.Part.Board;
import ColorBox.Backend.Entity.Part.Film;

import java.util.ArrayList;

/**
 * Класс реализующий тех. логику просчета материала Plastic для оклейки упаковки внутри
 */
public class Inside {
    // Создаются объекты пленки с техническими параметрами материала
    protected Plastic oracalBig = new Plastic(1260);
    protected Plastic oracalSmall = new Plastic(1000);
    protected Plastic dlc = new Plastic(1370);
    protected Plastic dlcP = new Plastic(1500);

    // Общие переменные для взаимодействия
    protected double rollOne, rollTwo;
    protected double small = 1.00;
    protected double big = 1.26;
    protected double dlcD = 1.37;
    protected double dlcPlusD = 1.5;
    protected int standardOne;
    protected int standardTwo;

    public String rollDlcPlus(ArrayList<Board> listOne, ArrayList<Board> listTwo, int number) {
        // В циклах ниже последовательно на каждый элемент,
        // следуя технической логике,
        // выясняется нужное количество материала
        String result = "Оклейка внутри:\n";
        for (Board a : listOne) {
            Film film = new Film(a.x, a.y);
            result +=  dlcPlusPlastic(film, number);
        }
        for (Board a : listTwo) {
            Film film = new Film(a.x, a.y);
            result += dlcPlusPlastic(film, number * 2);
        }

        // Сохраняются и округляются полученный результаты
        dlcP.setY(Math.round(dlcP.getY() * 100) / 100D);

        result += "\n На обкатку рекомендуется 1,5х" + dlcP.getY() + " м. пленки."
                + System.lineSeparator() + "________________________________\n";

        return result;
    }

    private String dlcPlusPlastic(Film filmDown, int number) {
        // вычисляется сколько элементов кладется в ряд на ширине материала
        standardOne = (int) (new CreatePlastic().create(filmDown, number, dlcP)).get(0);
        // Сколько материала требуется под эти элементы
        rollOne = (double) (new CreatePlastic().create(filmDown, number, dlcP)).get(1);

        String result = "На часть " + filmDown + " получится:\n";
        result += "- рулон 1,5 м. шириной -> " +
                String.format("%.0f", (rollOne * dlcPlusD))
                + " м2 (по " + standardOne + " шт. в ряд)\n";

        dlcP.setY(dlcP.getY() + (rollOne / dlcP.getX()));

        return result;
    }

    public String rollDlc(ArrayList<Board> listOne, ArrayList<Board> listTwo, int number) {
        // В циклах ниже последовательно на каждый элемент,
        // следуя технической логике,
        // выясняется нужное количество материала
        String result = "Оклейка внутри:\n";
        for (Board a : listOne) {
            Film film = new Film(a.x, a.y);
            result += dlcPlastic(film, number);
        }
        for (Board a : listTwo) {
            Film film = new Film(a.x, a.y);
            result += dlcPlastic(film, number * 2);
        }

        dlc.setY(Math.round(dlc.getY() * 100) / 100D);

        result += "\n На обкатку рекомендуется 1,37х" + dlc.getY() + " м. пленки."
                + System.lineSeparator() + "________________________________\n";

        return result;
    }

    private String dlcPlastic(Film filmDown, int number) {
        // вычисляется сколько элементов кладется в ряд на ширине материала
        standardOne = (int) (new CreatePlastic().create(filmDown, number, dlc)).get(0);
        // Сколько материала требуется под эти элементы
        rollOne = (double) (new CreatePlastic().create(filmDown, number, dlc)).get(1);

        String result = "На часть " + filmDown + " получится:\n";
        result += "- рулон 1,37 м. шириной -> " +
                String.format("%.0f", (rollOne * dlcD))
                + " м2 (по " + standardOne + " шт. в ряд)\n";

        dlc.setY(dlc.getY() + (rollOne / dlc.getX()));

        return result;
    }

    public String roll(ArrayList<Board> listOne, ArrayList<Board> listTwo, int number) {
        // В циклах ниже последовательно на каждый элемент,
        // следуя технической логике,
        // выясняется нужное количество материала
        String result = "Оклейка внутри:\n";
        for (Board a : listOne) {
            Film film = new Film(a.x, a.y);
            result += smallPlastic(film, number);
        }
        for (Board a : listTwo) {
            Film film = new Film(a.x, a.y);
            result += smallPlastic(film, number * 2);
        }

        // Предоставляется сводка по двум вариантам материала, чтобы итоговое решение
        // более выгодной сборки определялось на стороне производства
        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);

        result += "\n На обкатку рекомендуется 1,26х" + oracalBig.getY() +
                " м., 1х" + oracalSmall.getY() + " м. пленки."
                + System.lineSeparator() + "________________________________\n";

        return result;
    }

    protected String smallPlastic(Film filmDown, int number) {
        // вычисляется сколько элементов кладется в ряд на ширине материала "узкого"
        standardOne = (int) (new CreatePlastic().create(filmDown, number, oracalSmall)).get(0);
        rollOne = (double) (new CreatePlastic().create(filmDown, number, oracalSmall)).get(1);

        // вычисляется сколько элементов кладется в ряд на ширине материала "широкого"
        standardTwo = (int) (new CreatePlastic().create(filmDown, number, oracalBig)).get(0);
        rollTwo = (double) (new CreatePlastic().create(filmDown, number, oracalBig)).get(1);

        Double m22 = rollTwo * big;
        Double m21 = rollOne * small;

        String result = "На часть " + filmDown + " получится:\n";
        result += "- рулон 1 м. шириной -> " + String.format("%.0f", m21)
                + " м2 (по " + standardOne + " шт. в ряд)\n";
        result += "- рулон 1,26 м. шириной -> " + String.format("%.0f", m22)
                + " м2 (по " + standardTwo + " шт. в ряд)\n";

        // Сравнивается расход материала между двумя видами пленки
        // лучший вариант на основе тех. регламента становится рекомендованным
        if (m21 <= m22) {
            oracalSmall.setY(oracalSmall.getY() + (rollOne / oracalSmall.getX()));
        } else {
            oracalBig.setY(oracalBig.getY() + (rollTwo / oracalBig.getX()));
        }

        return result;
    }
}
