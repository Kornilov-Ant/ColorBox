package ColorBox.Backend.Service.DevelopPlastic;

import ColorBox.Backend.Entity.Box.BoxTwoCapLite;
import ColorBox.Backend.Entity.Part.Board;
import ColorBox.Backend.Entity.Part.Film;

import java.util.ArrayList;

/**
 * Класс, реализующий тех. логику просчета материала Plastic, для оклейки упаковки внутри
 * Подходит только для упаковок "Двойное дно"
 * Наследуется от класса Inside
 */
public class InsideTwoCap extends Inside {
    private ArrayList<Board> listOne = new ArrayList<>();
    private ArrayList<Board> listTwo = new ArrayList<>();

    public String roll(BoxTwoCapLite box, int number) {
        // Ниже вычисляется размер элемента дополнительного крепления
        // по тех. регламенту
        int h = ((box.getZ() + 2) - box.getG()) / 2;

        // В коллекции поэтапно кладутся заданные по тех. регламенту элементы объекта Board
        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getX() + 4, box.getZ() + 2));
        listTwo.add(new Board(box.getY(), box.getZ() + 2));
        listOne.add(new Board(box.getX() + 9, box.getY() + 9));
        listTwo.add(new Board(box.getX() + 9, h));
        listTwo.add(new Board(box.getY() + 5, h));

        // Ниже в циклах все коллекции обходятся поэтапно
        // выполняется бизнеслогика аналогичная классу Inside
        String result = "Оклейка внутри:";
        for (Board a : listOne) {
            Film film = new Film(a.x, a.y);
            smallPlastic(film, number);
        }
        for (Board a : listTwo) {
            Film film = new Film(a.x, a.y);
            smallPlastic(film, number * 2);
        }

        // Ниже в переменные метража добавляются результаты просчета
        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);

        result += "На обкатку рекомендуется 1,26х" + oracalBig.getY() +
                " м., 1х" + oracalSmall.getY() + " м. пленки."
                + System.lineSeparator() + "________________________________\n";

        return result;
    }

    protected String smallPlastic(Film filmDown, int number) {
        return super.smallPlastic(filmDown,number);
    }
}
