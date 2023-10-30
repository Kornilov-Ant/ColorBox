package ColorBox.Backend.Service.CheckService.ControlValues;

import javax.swing.*;

/**
 *  Класс с единственным методом, проверяющим входящие значения
 *
 *  Работает для проверки сторон
 *  без зависимости от других
 *  элементов упаковки
 *
 *  Расшифровка входных параметров:
 *  JTextField text - информация требующая проверки
 *  JLabel o - объект текстового поля интерфейса
 *  int one - минимально допустимое цифровое значение
 *  int two - максимально допустимое цифровое значение
 */
public class CheckXYZGNumber {

    public static String check(String text, int one, int two) {
        String result;
        try {
            if (Integer.parseInt(text) >= one && Integer.parseInt(text) <= two) {
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
