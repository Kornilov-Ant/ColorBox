package ColorBox.Backend.DevelopCartoon;

import ColorBox.Backend.CreateService.CreateCartoon;
import ColorBox.Backend.DevelopPlastic.PlasticMagicV;
import ColorBox.Backend.Box.BoxMagic;
import ColorBox.Backend.DevelopPlastic.Inside;
import ColorBox.Backend.Part.Board;
import ColorBox.Frontend.Play;

import java.util.ArrayList;

/**
 * Класс, в котором "собирается" коробка "Шкатулка вертикальная"
 * Наследуется от класса DevelopCap и расширяет его функционал
 */
public class DevelopMagicV extends DevelopCap {
//    // В этой коллекции хранятся элементы,
//    // которые потом будут производиться в одном экземпляре
//    private ArrayList<Board> insideOne = new ArrayList<>();
//
//    // В этой коллекции хранятся элементы,
//    // которые потом будут производиться в двойном экземпляре
//    private ArrayList<Board> insideTwo = new ArrayList<>();

    public void developMagicV(BoxMagic box, int number, int now, int plasticSelected) {
        // В коллекции поэтапно кладутся заданные по тех. регламенту элементы объекта Board
        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getY() + 4, box.getZ() + 2));
        listTwo.add(new Board(box.getX(), box.getZ() + 2));
        listTwo.add(new Board(box.getY() + 10, box.getY() + 7));
        listOne.add(new Board(box.getY() + 10, box.getF()));
        listOne.add(new Board(box.getY() + 10, box.getZ() + 6));

        // Добавление текста заголовка в статическую коллекцию
        Play.list.add("Коробка типа \"Шкатулка вертикальная\"\n");

        for (Board slide : listOne) {
            // В цикле на каждый элемент идет подсчет требуемого материала Cartoon
            // и добавление результата к переменной cartList
            aBack = new CreateCartoon().createCartoon(slide, number);
            cartList += aBack;

            // Добавление текста в статическую коллекцию
            Play.list.add("На сторону " + slide + " требуется " + aBack + " л.");
        }

        for (Board slide : listTwo) {
            // В цикле на каждый элемент идет подсчет требуемого материала Cartoon
            // и добавление результата к переменной cartList
            // (тираж умножается на два, так как каждого элемента нужно по 2 шт.)
            aBack = new CreateCartoon().createCartoon(slide, number * 2);
            cartList += aBack;

            // Добавление текста в статическую коллекцию
            Play.list.add("На сторону " + slide + " требуется " + String.format("%.1f", aBack) + " л.");
        }

        // Добавление текста в статическую коллекцию
        Play.list.add("Всего требуется " + String.format("%.1f", cartList)
                + " л. картона на тираж" + System.lineSeparator());

        // Если выбрана в интерфейсе опция "Обкатка внутри",
        // то запустится условие ниже
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

        PlasticMagicV magicV = new PlasticMagicV();
        // Добавление текста в статическую коллекцию
        Play.list.add(magicV.roll(box, number, plasticSelected));
    }
}