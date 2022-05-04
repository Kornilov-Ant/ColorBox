package ColorBox.Menu;

import javax.swing.*;

public class UpMenuBar {

    JMenuBar bar = new JMenuBar();

    public UpMenuBar() {
        JMenu menu = new JMenu("Меню");
        JMenuItem item1 = new JMenuItem("Сохранить просчет (не подключено)");
        JMenuItem item2 = new JMenuItem("Распечатать (не подключено)");
        JMenuItem item3 = new JMenuItem("Закрыть программу (не подключено)");
        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);
        menu.add(item3);

        JMenu about = new JMenu("Дополнительно");
        JMenuItem item4 = new JMenuItem("О программе (не подключено)");
        about.add(item4);

        bar.add(menu);
        bar.add(about);
    }

    public JMenuBar getBar() {
        return bar;
    }
}
