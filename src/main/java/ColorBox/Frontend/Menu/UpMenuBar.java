package ColorBox.Frontend.Menu;

import ColorBox.Backend.Service.CheckService.TextSave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * В классе реализована полоса управления приложением
 * Меню: Сохранение и распечатка, закрытие программы, помощь и "о программе"
 */
public class UpMenuBar extends JPanel implements ActionListener {

    // Объект хранящий в себе все настройки панели
    // Верхний бар с выпадающими элементами меню
    private JMenuBar bar = new JMenuBar();

    private static String report = "";

    public UpMenuBar() {
        // Создаем новый объект меню
        JMenu menu = new JMenu("Меню");

        // Создаем последовательно три объекта подменю и добавляем их к меню
        JMenuItem item1 = new JMenuItem("Сохранить просчет");
        JMenuItem item2 = new JMenuItem("Распечатать (не подключено)");
        JMenuItem item3 = new JMenuItem("Закрыть программу");
        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);
        menu.add(item3);

        // Создаем новый объект меню
        JMenu help = new JMenu("Помощь");
        // Создаем объект подменю и добавляем его к меню
        JMenuItem item4 = new JMenuItem("О программе");
        help.add(item4);

        // Добавления к верхнему бару двух объектов меню
        bar.add(menu);
        bar.add(help);

        // Прикрепление слушателелей на все элементы подменю
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
    }

    public JMenuBar getBar() {
        return bar;
    }

    // Действие при выборе конкретных пунктов подменю
    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();
        switch (com) {
            case "Закрыть программу":
                System.exit(0);
            case "Сохранить просчет":
                TextSave textSave = new TextSave();
                textSave.textSave(report);
            case "О программе":
                About about = new About();
                about.startAbout();
        }
    }

    public static void setReport(String report) {
        UpMenuBar.report = report;
    }
}
