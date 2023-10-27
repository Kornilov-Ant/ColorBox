package ColorBox.Backend.CreateService;

import ColorBox.Backend.Part.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateCartoonTest {

    @Test
    @DisplayName("Тест CreateCartoon")
    public void createCartoonTest() {
        boolean result = false;
        Board board = new Board(100, 200);
        CreateCartoon createCartoon = new CreateCartoon();
        if (createCartoon.createCartoon(board, 300) == 11.3) {
            result = true;
        }
        assertTrue(result);
    }
}
