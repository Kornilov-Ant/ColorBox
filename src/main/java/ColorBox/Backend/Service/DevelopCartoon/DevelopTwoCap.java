package ColorBox.Backend.Service.DevelopCartoon;

import ColorBox.Backend.Entity.Box.BoxTwoCap;
import ColorBox.Backend.Service.CreateService.CreateCartoon;
import ColorBox.Backend.Service.DevelopPlastic.InsideTwoCap;
import ColorBox.Backend.Service.DevelopPlastic.PlasticTwoCap;
import ColorBox.Backend.Entity.Part.Board;

import java.util.ArrayList;

/**
 * Класс, в котором "собирается" коробка "Двойное дно с одинаковыми бортами"
 * Наследуется от класса DevelopCap и расширяет его функционал
 */
public class DevelopTwoCap extends DevelopCap {
    // Дополнительная коллекция для объектов укрепления в крышку экземплярах
    private ArrayList<Board> listThree = new ArrayList<>();

    public String developTwoCap(BoxTwoCap box, int number, int now, int plasticSelected) {
        String result = "Коробка типа \"Двойное дно, выровненные борта\"\n";

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

            result += "На сторону " + slide +
                    " требуется " + aBack + " л.\n";
        }

        for (Board slide : listTwo) {
            // В цикле на каждый элемент идет подсчет требуемого материала Cartoon
            // и добавление результата к переменной cartList
            // (тираж умножается на два, так как каждого элемента нужно по 2 шт.)
            aBack = new CreateCartoon().createCartoon(slide, number * 2);
            cartList += aBack;

            result += "На сторону " + slide +
                    " требуется " + String.format("%.1f", aBack) + " л.\n";
        }

        for (Board slide : listThree) {
            // В цикле на каждый элемент идет подсчет требуемого материала Cartoon
            // и добавление результата к переменной cartList
            // (тираж умножается на два, так как каждого элемента нужно по 2 шт.)
            aBack = new CreateCartoon().createCartoon(slide, number * 2);
            cartList += aBack;

            result += "Внутряняя вставка в крышку " + slide +
                    " требует " + String.format("%.1f", aBack) + " л.\n";
        }

        result += "Всего требуется " + String.format("%.1f", cartList)
                + " л. картона на тираж" + System.lineSeparator() + "\n";

        if (now > 0) {
            InsideTwoCap inside = new InsideTwoCap();
            switch (now) {
                case 1:
                    result += "Обкатка внутри, материал \"Oracal\"\n";
                    result += inside.roll(listOne, listTwo, number);
                    break;
                case 2:
                    result += "Обкатка внутри, материал \"DLC 1.37 м.\"\n";
                    result += inside.rollDlc(listOne, listTwo, number);
                    break;
                case 3:
                    result += "Обкатка внутри, материал \"DLC 1.5 м.\"\n";
                    result += inside.rollDlcPlus(listOne, listTwo, number);
                    break;
            }
        }

        PlasticTwoCap plasticTwoCap = new PlasticTwoCap();
        result += plasticTwoCap.roll(box, number, plasticSelected, b);

        return result;
    }
}
