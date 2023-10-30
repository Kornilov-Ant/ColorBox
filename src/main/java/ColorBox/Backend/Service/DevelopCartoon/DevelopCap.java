package ColorBox.Backend.Service.DevelopCartoon;

import ColorBox.Backend.Service.CreateService.CreateCartoon;
import ColorBox.Backend.Service.DevelopPlastic.Inside;
import ColorBox.Frontend.*;
import ColorBox.Backend.Entity.Box.BoxCap;
import ColorBox.Backend.Service.DevelopPlastic.PlasticCap;
import ColorBox.Backend.Entity.Part.Board;

import java.util.ArrayList;

/**
 * Класс, в котором "собирается" коробка "Крышка-дно"
 */
public class DevelopCap {
    // В этой коллекции хранятся элементы,
    // которые потом будут производиться в одном экземпляре
    protected ArrayList<Board> listOne = new ArrayList<>();

    // В этой коллекции хранятся элементы,
    // которые потом будут производиться в двойном экземпляре
    protected ArrayList<Board> listTwo = new ArrayList<>();

    // Эта переменная отвечает за общее количество
    // требуемых материалов по картону
    protected double cartList;

    // Переменная для промежуточного хранения результатов
    // просчетов по материалу картона
    protected double aBack;


    public String developCap(BoxCap box, int number, int now, int plasticSelected) {
        // В коллекции поэтапно кладутся заданные по тех. регламенту элементы объекта Board
        listOne.add(new Board(box.getX() + 4, box.getY() + 4));
        listTwo.add(new Board(box.getX() + 4, box.getZ()));
        listTwo.add(new Board(box.getY(), box.getZ()));
        listOne.add(new Board(box.getX() + 9, box.getY() + 9));
        listTwo.add(new Board(box.getX() + 9, box.getF()));
        listTwo.add(new Board(box.getY() + 5, box.getF()));

        String result = "Коробка типа \"Крышка-дно\"\n";

        for (Board slide : listOne) {
            // В цикле на каждый элемент идет подсчет требуемого материала Cartoon
            // и добавление результата к переменной cartList
            aBack = new CreateCartoon().createCartoon(slide, number);
            cartList += aBack;

            result += "На сторону " + slide + " требуется " + String.format("%.1f", aBack) + " л.\n";
        }

        for (Board slide : listTwo) {
            // В цикле на каждый элемент идет подсчет требуемого материала Cartoon
            // и добавление результата к переменной cartList
            // (тираж умножается на два, так как каждого элемента нужно по 2 шт.)
            aBack = new CreateCartoon().createCartoon(slide, number * 2);
            cartList += aBack;

            result += "На сторону " + slide + " требуется " + String.format("%.1f", aBack) + " л.\n";
        }

        result += "Всего требуется " + String.format("%.1f", cartList)
                + " л. картона на тираж" + System.lineSeparator() + "\n";

        // Если выбрана в интерфейсе опция "Обкатка внутри",
        // то запустится условие ниже
        if (now > 0) {
            Inside inside = new Inside();
            // В зависимости от выбранного материала мы попадаем в требуемый case
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

        PlasticCap plasticCap = new PlasticCap();
        result += plasticCap.roll(box, number, plasticSelected);

        return result;
    }
}
