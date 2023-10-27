package ColorBox.Backend.CheckService.ControlValues;

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
    public static boolean check(JTextField text, JLabel o, int one, int two) {
        try {
            if (Integer.parseInt(text.getText()) >= one && Integer.parseInt(text.getText()) <= two) {

                // Проверка пройдена и в текстовое поле помещается индикатор
                // показывающий пользователю, что данные введены были корректно
                o.setText("\u2714");

                // Возвращается результат проверки - положительный
                return true;
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException exc) {

            // В случае провала проверки в текстовое поле помещается подсказка
            // для пользователя о допустимых значениях
            o.setText("от " + one + " до " + two);

            // Возвращается результат проверки - отрицательный
            return false;
        }
    }
}
