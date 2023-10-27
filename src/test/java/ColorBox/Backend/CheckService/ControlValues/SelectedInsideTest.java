package ColorBox.Backend.CheckService.ControlValues;

import ColorBox.Backend.CheckService.ControlValues.SelectedInside;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectedInsideTest {

    @Test
    @DisplayName("Тест SelectedInside 1/1,26")
    public void checkPositiveOneTest() {
        boolean result = false;
        if(SelectedInside.check("1/1,26") == 1) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест SelectedInside 1,37")
    public void checkPositiveTwoTest() {
        boolean result = false;
        if(SelectedInside.check("1,37") == 2) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест SelectedInside 1,5")
    public void checkPositiveThreeTest() {
        boolean result = false;
        if(SelectedInside.check("1,5") == 3) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест SelectedInside nothing")
    public void checkPositiveFourTest() {
        boolean result = false;
        if(SelectedInside.check("") == 0) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест SelectedInside null")
    public void checkPositiveFiveTest() {
        boolean result = false;
        try {
            SelectedInside.check(null);
        } catch (Exception e) {
            result = true;
        }
        assertTrue(result);
    }
}
