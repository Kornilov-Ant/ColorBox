package ColorBox.Backend.Service.CheckService;

import java.util.Random;

/**
 * Класс создает "Рандомное" значение для переменной "line"
 */
public class NameRandom {

    private String line;

    // Метод добавляет к строке четырехзначное
    // "рандомное" символьное значение
    private String letterRandom() {
        String letters = "";
        while (true) {
            int back = new Random().nextInt(122);
            if (back > 64 && back < 91 || back > 96 && back < 123) {
                if (letters.length() < 4) {
                    letters += (char) back;
                } else {
                    return letters;
                }
            }
        }
    }

    // Метод добавляет к строке тип упаковки латиницей
    // на основе входного параметра
    public String nameRandom(String report) {
        if (report.contains("Крышка-дно")) {
            line = "_Simple_box_#";
        } else if (report.contains("Шкатулка горизонтальная")) {
            line = "_Magnetic_boxG_#";
        } else if (report.contains("Шкатулка вертикальная")) {
            line = "_Magnetic_boxV_#";
        } else if (report.contains("Двойное дно, выровненные борта")) {
            line = "_Two_Cap_#";
        } else if (report.contains("Двойное дно, разные борта")) {
            line = "_Two_Cap_Lite_#";
        } else {
            throw new IllegalArgumentException();
        }
        line += letterRandom();
        return line;
    }

}
