package ColorBox.Frontend.ControlValues;

import javax.swing.*;

public class CheckH {
    public static boolean check(JTextField text, JTextField text2, JTextField text3, JLabel o, int one, int two) {
        try {
            if (Integer.parseInt(text.getText()) >= one
                    && Integer.parseInt(text.getText()) <= two
                    && Integer.parseInt(text.getText()) <= ((Integer.parseInt(text2.getText()) + 2)
                    - Integer.parseInt(text3.getText()))) {
                o.setText("\u2714");
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception exc) {
            o.setText("от " + one + " до " + two);
            return false;
        }
    }
}
