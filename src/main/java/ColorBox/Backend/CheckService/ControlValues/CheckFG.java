package ColorBox.Backend.CheckService.ControlValues;

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
    public static boolean check(JTextField text, JTextField text2, JLabel o, int one, int two) {
        try {
            if (Integer.parseInt(text.getText()) >= one
                    && Integer.parseInt(text.getText()) <= two
                    && Integer.parseInt(text.getText()) <= (Integer.parseInt(text2.getText()) + 2)) {

                // Проверка пройдена и в текстовое поле помещается индикатор
                // показывающий пользователю, что данные введены были корректно
                o.setText("\u2714");

                // Возвращается результат проверки - положительный
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception exc) {

            // В случае провала проверки в текстовое поле помещается подсказка
            // для пользователя о допустимых значениях
            o.setText("от " + one + " до " + two);

            // Возвращается результат проверки - отрицательный
            return false;
        }
    }
}
