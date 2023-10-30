package ColorBox.Backend.Service.CheckService.ControlValues;

import ColorBox.Backend.Service.CheckService.ControlValues.CheckFG;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckFGTest {

    private final int one = 15;

    private final int two = 450;

    @Test
    @DisplayName("Тест checkFGPositiveOne")
    public void checkPositiveOneTest() {
        boolean result = false;
        JTextField textField = new JTextField("15");
        JTextField textField2 = new JTextField("15");
        if (CheckFG.check(textField.getText(), textField2.getText(), one, two).equals("\u2714")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест checkFGPositiveTwo")
    public void checkPositiveTwoTest() {
        boolean result = false;
        JTextField textField = new JTextField("450");
        JTextField textField2 = new JTextField("450");
        if (CheckFG.check(textField.getText(), textField2.getText(), one, two).equals("\u2714")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест checkFGNegativeOne")
    public void checkNegativeOneTest() {
        boolean result = false;
        JTextField textField = new JTextField("14");
        JTextField textField2 = new JTextField("14");
        if (CheckFG.check(textField.getText(), textField2.getText(), one, two).equals("\u2714")) {
            result = true;
        }
        assertFalse(result);
    }

    @Test
    @DisplayName("Тест checkFGNegativeTwo")
    public void checkNegativeTwoTest() {
        boolean result = false;
        JTextField textField = new JTextField("451");
        JTextField textField2 = new JTextField("451");
        if (CheckFG.check(textField.getText(), textField2.getText(), one, two).equals("\u2714")) {
            result = true;
        }
        assertFalse(result);
    }
}
