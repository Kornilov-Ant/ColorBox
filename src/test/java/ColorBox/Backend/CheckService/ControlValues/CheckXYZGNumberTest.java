package ColorBox.Backend.CheckService.ControlValues;

import ColorBox.Backend.CheckService.ControlValues.CheckXYZGNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckXYZGNumberTest {


    private final int one = 30;

    private final int two = 690;

    @Test
    @DisplayName("Тест checkXYZGNumberPositiveOne")
    public void checkPositiveOneTest() {
        boolean result = false;
        JTextField textField = new JTextField("30");
        if (CheckXYZGNumber.check(textField, new JLabel(), one, two)) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест checkXYZGNumberPositiveTwo")
    public void checkPositiveTwoTest() {
        boolean result = false;
        JTextField textField = new JTextField("690");
        if (CheckXYZGNumber.check(textField, new JLabel(), one, two)) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест checkXYZGNumberNegativeOne")
    public void checkNegativeOneTest() {
        boolean result = false;
        JTextField textField = new JTextField("29");
        if (CheckXYZGNumber.check(textField, new JLabel(), one, two)) {
            result = true;
        }
        assertFalse(result);
    }

    @Test
    @DisplayName("Тест checkXYZGNumberNegativeTwo")
    public void checkNegativeTwoTest() {
        boolean result = false;
        JTextField textField = new JTextField("691");
        if (CheckXYZGNumber.check(textField, new JLabel(), one, two)) {
            result = true;
        }
        assertFalse(result);
    }
}
