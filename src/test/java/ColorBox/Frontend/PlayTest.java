package ColorBox.Frontend;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayTest {

    @BeforeEach
    public void cleanHistory() {
        Play.report = "";
        Play.list = new ArrayList<>();
    }

    @Test
    @DisplayName("Тест Cap positive")
    public void capPositiveTest() {
        boolean result = false;

        new Play().cap(100, 200, 300, 200, 500, 1, -1);

        if (Play.report.contains("Всего требуется 325.0 л. картона на тираж")
                && Play.report.contains("На обкатку рекомендуется 1,26х33.8 м., 1х122.8 м. пленки.")
                && Play.report.contains("На часть 543x643 получится:")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест Cap negative")
    public void capNegativeTest() {
        boolean result = false;

        new Play().cap(100, 200, 300, 200, 500, 100, 100);

        if (Play.report.contains("Всего требуется")
                && Play.report.contains("На обкатку рекомендуется")
                && Play.report.contains("На часть")) {
            result = true;
        }
        assertFalse(result);
    }

    @Test
    @DisplayName("Тест MagicG positive")
    public void magicGPositiveTest() {
        boolean result = false;

        new Play().magicG(100, 100, 100, 100, 500, 1, -1);

        if (Play.report.contains("Всего требуется 83.7 л. картона на тираж")
                && Play.report.contains("На обкатку рекомендуется 1,26х6.75 м., 1х38.48 м. пленки.")
                && Play.report.contains("На часть 100x253 получится:")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест MagicG negative")
    public void magicGNegativeTest() {
        boolean result = false;

        new Play().magicG(100, 100, 100, 100, 500, 100, 100);

        if (Play.report.contains("Всего требуется 83.7 л. картона на тираж")
                && Play.report.contains("На обкатку рекомендуется 1,26х6.75 м., 1х38.48 м. пленки.")
                && Play.report.contains("На часть 100x253 получится:")) {
            result = true;
        }
        assertFalse(result);
    }

    @Test
    @DisplayName("Тест MagicV positive")
    public void magicVPositiveTest() {
        boolean result = false;

        new Play().magicV(100, 100, 100, 100, 500, 1, -1);

        if (Play.report.contains("Всего требуется 83.7 л. картона на тираж")
                && Play.report.contains("На обкатку рекомендуется 1,26х6.75 м., 1х38.48 м. пленки.")
                && Play.report.contains("На часть 100x253 получится:")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест MagicV negative")
    public void magicVNegativeTest() {
        boolean result = false;

        new Play().magicV(100, 100, 100, 100, 500, 100, 100);

        if (Play.report.contains("Всего требуется 83.7 л. картона на тираж")
                && Play.report.contains("На обкатку рекомендуется 1,26х6.75 м., 1х38.48 м. пленки.")
                && Play.report.contains("На часть 100x253 получится:")) {
            result = true;
        }
        assertFalse(result);
    }

    @Test
    @DisplayName("Тест TwoCapLite positive")
    public void twoCapLitePositiveTest() {
        boolean result = false;

        new Play().twoCapLite(100,100,100,100, 500, 1, -1);

        if (Play.report.contains("Всего требуется 67.1 л. картона на тираж")
                && Play.report.contains("На обкатку рекомендуется 1,26х6.75 м., 1х27.31 м. пленки.")
                && Play.report.contains("На часть 342x342 получится:")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест TwoCapLite negative")
    public void twoCapLiteNegativeTest() {
        boolean result = false;

        new Play().twoCapLite(100,100,100,100, 500, 100, 100);

        if (Play.report.contains("Всего требуется 67.1 л. картона на тираж")
                && Play.report.contains("На обкатку рекомендуется 1,26х6.75 м., 1х27.31 м. пленки.")
                && Play.report.contains("На часть 342x342 получится:")) {
            result = true;
        }
        assertFalse(result);
    }

    @Test
    @DisplayName("Тест TwoCap positive")
    public void twoCapPositiveTest() {
        boolean result = false;

        new Play().twoCap(100, 100, 100, 100, 100, 100, 500, 1, -1);

        if (Play.report.contains("Всего требуется 67.0 л. картона на тираж")
                && Play.report.contains("На обкатку рекомендуется 1,26х6.14 м., 1х27.1 м. пленки.")
                && Play.report.contains("На часть 342x342 получится:")) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест TwoCap negative")
    public void twoCapNegativeTest() {
        boolean result = false;

        new Play().twoCap(100, 100, 100, 100, 100, 100, 500, 100, 100);

        if (Play.report.contains("Всего требуется 67.0 л. картона на тираж")
                && Play.report.contains("На обкатку рекомендуется 1,26х6.14 м., 1х27.1 м. пленки.")
                && Play.report.contains("На часть 342x342 получится:")) {
            result = true;
        }
        assertFalse(result);
    }
}
