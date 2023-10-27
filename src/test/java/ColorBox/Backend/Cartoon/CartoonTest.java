package ColorBox.Backend.Cartoon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartoonTest {

    @Test
    @DisplayName("Тест Lux")
    public void luxTest() {
        boolean result = false;
        Lux lux = new Lux();
        if (lux.getX() == 1000 && lux.getY() == 700) {
            result = true;
        }
        assertTrue(result);
    }
}
