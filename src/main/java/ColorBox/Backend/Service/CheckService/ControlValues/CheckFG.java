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
 * JTextField text - информация требующая проверки
 * JTextField text2 - данные второго, сравниваемого элемента
 * JLabel o - объект текстового поля интерфейса
 * int one - минимально допустимое цифровое значение
 * int two - максимально допустимое цифровое значение
 */
public class CheckFG {

    public static String check(String text, String text2, int one, int two) {
        String result;
        try {
            if (Integer.parseInt(text) >= one
                    && Integer.parseInt(text) <= two
                    && Integer.parseInt(text) <= Integer.parseInt(text2) + 2) {
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
