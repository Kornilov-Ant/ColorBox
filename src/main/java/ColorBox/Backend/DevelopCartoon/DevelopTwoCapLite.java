package ColorBox.Backend.DevelopCartoon;

import ColorBox.Backend.Box.BoxTwoCapLite;
import ColorBox.Backend.CreateService.CreateCartoon;
import ColorBox.Backend.DevelopPlastic.Inside;
import ColorBox.Backend.DevelopPlastic.PlasticTwoCapLite;
import ColorBox.Backend.Part.Board;
import ColorBox.Frontend.Play;

import java.util.ArrayList;

/**
 * Класс, в котором "собирается" коробка "Двойное дно разные борта"
 * Наследуется от класса DevelopCap и расширяет его функционал
 */
public class DevelopTwoCapLite extends DevelopCap {
    // Дополнительная коллекция для объектов укрепления в крышку
    private ArrayList<Board> listThree = new ArrayList<>();

    public void developTwoCap(BoxTwoCapLite box, int number, int now, int plasticSelected) {
        // Ниже вычисляется размер элемента дополнительного крепления
        // по тех. регламенту
        int h = ((box.getZ() + 2) - box.getG()) / 2;

        // В коллекции поэтапно кладутся заданные по тех. регламенту элементы объекта Board
        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getX() + 4, box.getZ() + 2));
        listTwo.add(new Board(box.getY(), box.getZ() + 2));
        listTwo.add(new Board(box.getX() + 9, box.getY() + 9));
        listThree.add(new Board(box.getX() + 9, h));
        listThree.add(new Board(box.getY() + 5, h));

        // Добавление текста заголовка в статическую коллекцию
        Play.list.add("Коробка типа \"Двойное дно, разные борта\"\n");

        for (Board slide : listOne) {
            // В цикле на каждый элемент идет подсчет требуемого материала Cartoon
            // и добавление результата к переменной cartList
            aBack = new CreateCartoon().createCartoon(slide, number);
            cartList += aBack;

            // Добавление текста в статическую коллекцию
            Play.list.add("На сторону " + slide +
                    " требуется " + aBack + " л.");
        }

        for (Board slide : listTwo) {
            // В цикле на каждый элемент идет подсчет требуемого материала Cartoon
            // и добавление результата к переменной cartList
            // (тираж умножается на два, так как каждого элемента нужно по 2 шт.)
            aBack = new CreateCartoon().createCartoon(slide, number * 2);
            cartList += aBack;

            // Добавление текста в статическую коллекцию
            Play.list.add("На сторону " + slide +
                    " требуется " + String.format("%.1f", aBack) + " л.");
        }

        for (Board slide : listThree) {
            // В цикле на каждый элемент идет подсчет требуемого материала Cartoon
            // и добавление результата к переменной cartList
            // (тираж умножается на два, так как каждого элемента нужно по 2 шт.)
            aBack = new CreateCartoon().createCartoon(slide, number * 4);
            cartList += aBack;

            // Добавление текста в статическую коллекцию
            Play.list.add("На сторону " + slide +
                    " требуется " + String.format("%.1f", aBack) + " л.");
        }

        // Добавление текста в статическую коллекцию
        Play.list.add("Всего требуется " + String.format("%.1f", cartList)
                + " л. картона на тираж" + System.lineSeparator());

        if (now > 0) {
            Inside inside = new Inside();
            switch (now) {
                case 1:
                    // Добавление текста в статическую коллекцию
                    Play.list.add("Обкатка внутри, материал \"Oracal\"\n");
                    Play.list.add(inside.roll(listOne, listTwo, number));
                    break;
                case 2:
                    // Добавление текста в статическую коллекцию
                    Play.list.add("Обкатка внутри, материал \"DLC 1.37 м.\"\n");
                    Play.list.add(inside.rollDlc(listOne, listTwo, number));
                    break;
                case 3:
                    // Добавление текста в статическую коллекцию
                    Play.list.add("Обкатка внутри, материал \"DLC 1.5 м.\"\n");
                    Play.list.add(inside.rollDlcPlus(listOne, listTwo, number));
                    break;
            }
        }

        PlasticTwoCapLite plasticTwoCapLite = new PlasticTwoCapLite();
        // Добавление текста в статическую коллекцию
        Play.list.add(plasticTwoCapLite.roll(box, number, plasticSelected));
    }
}
