package ColorBox.Backend.Service.CheckService.ControlValues;

import javax.swing.*;

/**
 * Класс с единственным методом, проверяющим входящие значения
 *
 * Работает для проверки сторон,
 * которые зависят от размера других
 * элементов упаковки
 *
 * Расшифровка входных параметров:
 * JTextField text - информация, требующая проверки
 * JTextField text2 - данные второго, сравниваемого элемента
 * JTextField text3 - данные третьего, сравниваемого элемента
 * JLabel o - объект текстового поля интерфейса
 * int one - минимально допустимое цифровое значение
 * int two - максимально допустимое цифровое значение
 */
public class CheckH {

    public static String check(String text1, String text2, String text3, int one, int two) {
        String result;
        try {
            if (Integer.parseInt(text1) >= one
                    && Integer.parseInt(text1) <= two
                    && Integer.parseInt(text1) <= ((Integer.parseInt(text2) + 2)
                    - Integer.parseInt(text3))) {
                result = "\u2714";
            } else {
                result = "от " + one + " до " + two;
            }
        } catch (RuntimeException e) {
            result = "от " + one + " до " + two;
        }
        return result;
    }
}
