package ColorBox.Backend.Entity.Part;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartTest {

    @Test
    @DisplayName("Тест Board")
    public void boardTest() {
        boolean result = false;
        Board board = new Board(1, 2);
        if (board.getX() == 1 && board.getY() == 2) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест Film")
    public void filmTest() {
        boolean result = false;
        Film film = new Film(3, 4);
        if (film.getX() == 3 && film.getY() == 4) {
            result = true;
        }
        assertTrue(result);
    }
}
