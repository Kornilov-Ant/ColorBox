package ColorBox.Backend.DevelopPlastic;

import ColorBox.Backend.Part.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsideTest {


    private final Inside inside = new Inside();

    @Test
    @DisplayName("Тест rollDlcPlus")
    public void rollDlcPlusTest() {
        boolean result = false;
        ArrayList<Board> listOne = new ArrayList<>();
        ArrayList<Board> listTwo = new ArrayList<>();
        int number = 250;
        listOne.add(new Board(100, 200));
        listOne.add(new Board(200, 300));
        if (inside.rollDlcPlus(listOne, listTwo, number) != null &&
                !inside.rollDlcPlus(listOne, listTwo, number).equals("") &&
                !inside.rollDlcPlus(listOne, listTwo, number).equals(" ")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест rollDlc")
    public void rollDlcTest() {
        boolean result = false;
        ArrayList<Board> listOne = new ArrayList<>();
        ArrayList<Board> listTwo = new ArrayList<>();
        int number = 250;
        listOne.add(new Board(100, 200));
        listOne.add(new Board(200, 300));
        if (inside.rollDlc(listOne, listTwo, number) != null &&
                !inside.rollDlc(listOne, listTwo, number).equals("") &&
                !inside.rollDlc(listOne, listTwo, number).equals(" ")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест roll")
    public void rollTest() {
        boolean result = false;
        ArrayList<Board> listOne = new ArrayList<>();
        ArrayList<Board> listTwo = new ArrayList<>();
        int number = 250;
        listOne.add(new Board(100, 200));
        listOne.add(new Board(200, 300));
        if (inside.roll(listOne, listTwo, number) != null &&
                !inside.roll(listOne, listTwo, number).equals("") &&
                !inside.roll(listOne, listTwo, number).equals(" ")) {
            result = true;
        }
        assertTrue(result);
    }
}
