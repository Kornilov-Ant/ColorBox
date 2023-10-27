package ColorBox.Backend.CheckService;

import lombok.Getter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Класс сохраняет переданную строку в файл
 */
@Getter
public class TextSave {
    // В этой переменной хранится путь сохранения с именем файла
    private String b;

    public void textSave(String line) {
        try {

            /*
            Путь складывается из:
            1) Папка пользователя в системе
            2) + имя папки "Documents"
            3) + Дата сохранения + час и минута сохранения
            4) Строка полученная в методе "nameRandom" класса NameRandom
             */
            b = System.getProperty("user.home")
                    + "/Documents/"
                    + LocalDate.now() + "_"
                    + LocalTime.now().getHour() + "-"
                    + LocalTime.now().getMinute()
                    + new NameRandom().nameRandom(line);

            // Сохранение файла
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
