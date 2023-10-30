package ColorBox.Backend.Service.CheckService;

import ColorBox.Backend.Service.CheckService.TextSave;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextSaveTest {

    @Test
    @DisplayName("Тест TextSave")
    public void textSaveTest() {
        boolean result = false;

        TextSave textSave = new TextSave();
        textSave.textSave("Крышка-дно");

        File file = new File(textSave.getB());

        if (file.delete()) {
            result = true;
        }

        assertTrue(result);
    }
}
