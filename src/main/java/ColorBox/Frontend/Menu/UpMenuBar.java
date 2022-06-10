package ColorBox.Frontend.Menu;

import ColorBox.Frontend.Menu.Service.TextSave;
import ColorBox.Frontend.Play;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpMenuBar implements ActionListener{

    private JMenuBar bar = new JMenuBar();

    public UpMenuBar() {
        JMenu menu = new JMenu("Меню");
        JMenuItem item1 = new JMenuItem("Сохранить просчет");
        JMenuItem item2 = new JMenuItem("Распечатать (не подключено)");
        JMenuItem item3 = new JMenuItem("Закрыть программу");
        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);
        menu.add(item3);

        JMenu help = new JMenu("Помощь");
        JMenuItem item4 = new JMenuItem("О программе (не подключено)");
        help.add(item4);

        bar.add(menu);
        bar.add(help);

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
    }

    public JMenuBar getBar() {
        return bar;
    }

    public void actionPerformed(ActionEvent e){
        String com = e.getActionCommand();
        switch (com){
            case "Закрыть программу":
                System.exit(0);
            case "Сохранить просчет":
                TextSave textSave = new TextSave();
                textSave.textSave(Play.report);
        }
    }
}
