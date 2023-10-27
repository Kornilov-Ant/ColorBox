package ColorBox.Backend.Box;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoxTest {

    @Test
    @DisplayName("Тест BoxCap")
    public void boxCapTest() {
        boolean result = false;
        BoxCap cap = new BoxCap(1, 2, 3, 4);
        if (cap.getX() == 1 && cap.getY() == 2 && cap.getZ() == 3 && cap.getF() == 4) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест BoxMagic")
    public void boxMagicTest() {
        boolean result = false;
        BoxMagic magic = new BoxMagic(1, 2, 3, 4);
        if (magic.getX() == 1 && magic.getY() == 2 && magic.getZ() == 3 && magic.getF() == 4) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест BoxTwoCap")
    public void boxTwoCapTest() {
        boolean result = false;
        BoxTwoCap twoCap = new BoxTwoCap(1, 2, 3, 4, 5, 6);
        if (twoCap.getX() == 1 && twoCap.getY() == 2 && twoCap.getZ() == 3 &&
                twoCap.getF() == 4 && twoCap.getG() == 5 && twoCap.getH() == 6) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест BoxTwoCapLite")
    public void boxTwoCapLiteTest() {
        boolean result = false;
        BoxTwoCapLite twoCapLite = new BoxTwoCapLite(1, 2, 3, 4);
        if (twoCapLite.getX() == 1 && twoCapLite.getY() == 2
                && twoCapLite.getZ() == 3 && twoCapLite.getG() == 4) {
            result = true;
        }
        assertTrue(result);
    }
}
