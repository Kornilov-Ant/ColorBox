package ColorBox.Frontend.Menu.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class TextSave {
    public void textSave(String line) {
        String b;
        try {
            // /Users/antonfrid/Documents/
            b = System.getProperty("user.home")
                    + "/Documents/"
                    + LocalDate.now() + "_"
                    + LocalTime.now().getHour() + "-"
                    + LocalTime.now().getMinute()
                    + new NameRandom().nameRandom(line);
            try (FileOutputStream fileOutputStream = new FileOutputStream(b)) {
                byte[] bytes = line.getBytes();
                fileOutputStream.write(bytes, 0, bytes.length);
                System.out.println("Файл сохранен");
            } catch (IOException e) {
                System.out.println("Ошибка сохранения, обратитесь к разработчику");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка сохранения, обратитесь к разработчику");
        }
    }
}
