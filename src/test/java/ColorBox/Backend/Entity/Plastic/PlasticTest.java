package ColorBox.Backend.Entity.Plastic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlasticTest {

    @Test
    @DisplayName("Тест Plastic")
    public void plasticTest() {
        boolean result = false;
        Plastic plastic = new Plastic(1234);
        if (plastic.getX() == 1234 &&
                plastic.getY() == 0.0 &&
                plastic.getZ() == 500000.0) {
            plastic.setY(3.4);
            if (plastic.getY() == 3.4) {
                result = true;
            }
        }
        assertTrue(result);
    }
}
