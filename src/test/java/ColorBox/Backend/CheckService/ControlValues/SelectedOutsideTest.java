package ColorBox.Backend.CheckService.ControlValues;

import ColorBox.Backend.CheckService.ControlValues.SelectedOutside;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectedOutsideTest {

    @Test
    @DisplayName("Тест SelectedOutside 1,37")
    public void checkPositiveTwoTest() {
        boolean result = false;
        if(SelectedOutside.check("1,37") == 0) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест SelectedOutside 1,5")
    public void checkPositiveThreeTest() {
        boolean result = false;
        if(SelectedOutside.check("1,5") == 1) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест SelectedOutside nothing")
    public void checkPositiveFourTest() {
        boolean result = false;
        if(SelectedOutside.check("") == -1) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест SelectedOutside null")
    public void checkPositiveFiveTest() {
        boolean result = false;
        try {
            SelectedOutside.check(null);
        } catch (Exception e) {
            result = true;
        }
        assertTrue(result);
    }
}
