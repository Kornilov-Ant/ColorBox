package ColorBox.Frontend.ControlValues;

import javax.swing.*;

public class CheckXYZGNumber {
    public static boolean check(JTextField text, JLabel o, int one, int two) {
        try {
            if (Integer.parseInt(text.getText()) >= one && Integer.parseInt(text.getText()) <= two) {
                o.setText("\u2714");
                return true;
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException exc) {
            o.setText("от " + one + " до " + two);
            return false;
        }
    }
}
