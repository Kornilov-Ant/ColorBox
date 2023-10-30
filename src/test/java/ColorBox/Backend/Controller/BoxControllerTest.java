package ColorBox.Backend.Controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoxControllerTest {

    private final BoxController controller = new BoxController();

    @Test
    @DisplayName("Тест Controller Positive")
    public void checkPositive() {
        assertTrue(controller.rest("Крышка-дно&&&&&&Нет&1/1,26&2024-01-15 16:51").equals("ERROR") ? false : true);
    }

    @Test
    @DisplayName("Тест Controller Negativ")
    public void checkNegative() {
        assertTrue(controller.rest("").equals("ERROR") ? true : false);
    }
}
