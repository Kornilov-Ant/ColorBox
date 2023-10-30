package ColorBox.Backend.Service.DevelopCartoon;

import ColorBox.Backend.Service.CreateService.CreateCartoon;
import ColorBox.Backend.Service.DevelopPlastic.PlasticMagicV;
import ColorBox.Backend.Entity.Box.BoxMagic;
import ColorBox.Backend.Service.DevelopPlastic.Inside;
import ColorBox.Backend.Entity.Part.Board;

/**
 * Класс, в котором "собирается" коробка "Шкатулка вертикальная"
 * Наследуется от класса DevelopCap и расширяет его функционал
 */
public class DevelopMagicV extends DevelopCap {

    public String developMagicV(BoxMagic box, int number, int now, int plasticSelected) {
        // В коллекции поэтапно кладутся заданные по тех. регламенту элементы объекта Board
        listOne.add(new Board(box.getX(), box.getY()));
        listTwo.add(new Board(box.getY() + 4, box.getZ() + 2));
        listTwo.add(new Board(box.getX(), box.getZ() + 2));
        listTwo.add(new Board(box.getY() + 10, box.getY() + 7));
        listOne.add(new Board(box.getY() + 10, box.getF()));
        listOne.add(new Board(box.getY() + 10, box.getZ() + 6));

        String result = "Коробка типа \"Шкатулка вертикальная\"\n";

        for (Board slide : listOne) {
            // В цикле на каждый элемент идет подсчет требуемого материала Cartoon
            // и добавление результата к переменной cartList
            aBack = new CreateCartoon().createCartoon(slide, number);
            cartList += aBack;

            result += "На сторону " + slide + " требуется " + aBack + " л.\n";
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

        PlasticMagicV magicV = new PlasticMagicV();
        result += magicV.roll(box, number, plasticSelected);

        return result;
    }
}