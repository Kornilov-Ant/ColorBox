package ColorBox.Backend.DevelopCartoon;

import ColorBox.Backend.Box.BoxTwoCap;
import ColorBox.Backend.CreateService.CreateCartoon;
import ColorBox.Backend.DevelopPlastic.InsideTwoCap;
import ColorBox.Backend.DevelopPlastic.PlasticTwoCap;
import ColorBox.Backend.Part.Board;
import ColorBox.Frontend.Play;

import java.util.ArrayList;

/**
 * Класс, в котором "собирается" коробка "Двойное дно с одинаковыми бортами"
 * Наследуется от класса DevelopCap и расширяет его функционал
 */
public class DevelopTwoCap extends DevelopCap {
    // Дополнительная коллекция для объектов укрепления в крышку экземплярах
    private ArrayList<Board> listThree = new ArrayList<>();

    public void developTwoCap(BoxTwoCap box, int number, int now, int plasticSelected) {
        // Добавление текста заголовка в статическую коллекцию
        Play.list.add("Коробка типа \"Двойное дно, выровненные борта\"\n");

        // Ниже вычисляется размер элемента дополнительного крепления
        // по тех. регламенту
        if (box.getF() != box.getZ()) {
            int a = (box.getZ() + 2) - box.getF();
            listThree.add(new Board(box.getX() + 4, a));
        }
        int b = (box.getZ() + 2) - (box.getG() + 2) - box.getH();

        // В коллекции поэтапно кладутся заданные по тех. регламенту элементы объекта Board
        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getX() + 4, box.getF() + 2));
        listTwo.add(new Board(box.getY(), box.getF() + 2));

        listTwo.add(new Board(box.getX() + 9, box.getY() + 9));
        listTwo.add(new Board(box.getX() + 9, box.getG()));
        listTwo.add(new Board(box.getY() + 5, box.getG()));
        listTwo.add(new Board(box.getX() + 9, b));
        listTwo.add(new Board(box.getY() + 5, b));


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
            aBack = new CreateCartoon().createCartoon(slide, number * 2);
            cartList += aBack;

            // Добавление текста в статическую коллекцию
            Play.list.add("Внутряняя вставка в крышку " + slide +
                    " требует " + String.format("%.1f", aBack) + " л.");
        }

        // Добавление текста в статическую коллекцию
        Play.list.add("Всего требуется " + String.format("%.1f", cartList)
                        + " л. картона на тираж" + System.lineSeparator());

        if (now > 0) {
            InsideTwoCap inside = new InsideTwoCap();
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

        PlasticTwoCap plasticTwoCap = new PlasticTwoCap();
        // Добавление текста в статическую коллекцию
        Play.list.add(plasticTwoCap.roll(box, number, plasticSelected, b));
    }
}
