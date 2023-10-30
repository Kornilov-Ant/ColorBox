package ColorBox.Backend.Service.CheckService.ControlValues;

import ColorBox.Backend.Service.CheckService.ControlValues.CheckH;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckHTest {

    private final int one = 0;

    private final int two = 350;

    @Test
    @DisplayName("Тест checkHPositiveOne")
    public void checkPositiveOneTest() {
        boolean result = false;
        JTextField textField = new JTextField("0");
        JTextField textField2 = new JTextField("0");
        JTextField textField3 = new JTextField("0");
        if (CheckH.check(textField.getText(), textField2.getText(), textField3.getText(), one, two).equals("\u2714")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест checkHPositiveTwo")
    public void checkPositiveTwoTest() {
        boolean result = false;
        JTextField textField = new JTextField("350");
        JTextField textField2 = new JTextField("400");
        JTextField textField3 = new JTextField("50");
        if (CheckH.check(textField.getText(), textField2.getText(), textField3.getText(), one, two).equals("\u2714")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест checkHNegativeOne")
    public void checkNegativeOneTest() {
        boolean result = false;
        JTextField textField = new JTextField("-1");
        JTextField textField2 = new JTextField("100");
        JTextField textField3 = new JTextField("0");
        if (CheckH.check(textField.getText(), textField2.getText(), textField3.getText(), one, two).equals("\u2714")) {
            result = true;
        }
        assertFalse(result);
    }

    @Test
    @DisplayName("Тест checkHNegativeTwo")
    public void checkNegativeTwoTest() {
        boolean result = false;
        JTextField textField = new JTextField("351");
        JTextField textField2 = new JTextField("0");
        JTextField textField3 = new JTextField("0");
        if (CheckH.check(textField.getText(), textField2.getText(), textField3.getText(), one, two).equals("\u2714")) {
            result = true;
        }
        assertFalse(result);
    }
}
