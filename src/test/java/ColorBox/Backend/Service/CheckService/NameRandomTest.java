package ColorBox.Backend.Service.CheckService;

import ColorBox.Backend.Service.CheckService.NameRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NameRandomTest {

    @Test
    @DisplayName("Тест NameRandom")
    public void nameRandomTest() {
        NameRandom nameRandom = new NameRandom();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String back = nameRandom.nameRandom("Крышка-дно");
            back = back.substring(back.length() - 4, back.length());
            if (list.contains(back)) {
                assertTrue(false);
            }
            list.add(back);
        }
        assertTrue(true);
    }

    @Test
    @DisplayName("Тест NameRandom All")
    public void nameRandomAllTest() {
        NameRandom nameRandom = new NameRandom();
        if (nameRandom.nameRandom("Крышка-дно")
                .startsWith("_Simple_box_#")) {
            if (nameRandom.nameRandom("Шкатулка горизонтальная")
                    .startsWith("_Magnetic_boxG_#")) {
                if (nameRandom.nameRandom("Шкатулка вертикальная")
                        .startsWith("_Magnetic_boxV_#")) {
                    if (nameRandom.nameRandom("Двойное дно, выровненные борта")
                            .startsWith("_Two_Cap_#")) {
                        if (nameRandom.nameRandom("Двойное дно, разные борта")
                                .startsWith("_Two_Cap_Lite_#")) {
                            try {
                                nameRandom.nameRandom("error");
                            } catch (IllegalArgumentException exception) {
                                assertTrue(true);
                            }
                        }
                    }
                }
            }
        } else {
            assertTrue(false);
        }
    }
}
