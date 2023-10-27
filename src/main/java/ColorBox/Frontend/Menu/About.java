package ColorBox.Frontend.Menu;

import javax.swing.*;
import java.awt.*;

/**
 * В классе реализовано действие меню при нажатие клавиши меню "О программе"
 */
public class About {

    // Версия приложения
    private String buildNumber = "1.0.3";

    // Дата версии приложения
    private String buildData = "от 27 октября 2023 г.";

    /*
    В методе создается новое окно,
    ему задаются параметры размера
    и кладется внутрь объект текста "textMain"
    с заранее заготовленными данными
     */
    public void startAbout() {
        String textMain = "Разработчик:" + System.lineSeparator() +
                "Корнилов Антон" + System.lineSeparator() +
                System.lineSeparator() +
                "Telegram для связи:" + System.lineSeparator() +
                "@kornilov_ant" + System.lineSeparator() +
                System.lineSeparator() +
                "Версия приложения:" + System.lineSeparator() +
                buildNumber + " (" + buildData +")";

        JFrame window = new JFrame();
        window.setLayout(new GridBagLayout());

        JTextArea jTextArea = new JTextArea(textMain);
        jTextArea.setEditable(false);
        jTextArea.setBackground(null);
        window.add(jTextArea);

        window.setSize(250, 200);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        window.setVisible(true);
    }
}
