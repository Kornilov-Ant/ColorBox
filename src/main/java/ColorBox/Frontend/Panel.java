package ColorBox.Frontend;

import ColorBox.Frontend.BlockPanel.*;
import ColorBox.Frontend.Menu.UpMenuBar;

import javax.swing.*;
import java.awt.*;

/**
 *  Класс отвечающий за общий внешний вид окна и вкладки
 */
public class Panel extends JPanel {

    public Panel() {
        // Устанавливаем гридер (разделитель окна/блок) по ячейкам
        setLayout(new GridBagLayout());

        // Создается горизонтальный одинарный "узкий" гридер (блок) для будущего элемента
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.gridy = 0;

        // Добавляем в общее окно верхнюю полосу управления приложением
        add(new UpMenuBar().getBar(), constraints);

        // Меняются параметры гридера с указанием размера помещаемого элемента
        constraints.gridy = 1;
        constraints.weighty = 325;
        constraints.ipady = 600;

        // Создается панель вкладок
        // и они последовательно в нее добавляются
        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        jTabbedPane.addTab("Крышка-дно", new PaneCap());
        jTabbedPane.addTab("Шкатулка гор.", new PaneMagicG());
        jTabbedPane.addTab("Шкатулка вер.", new PaneMagicV());
        jTabbedPane.addTab("Двойное дно", new PaneTwoCapLite());
        jTabbedPane.addTab("Двойное дно (разный борт)", new PaneTwoCap());

        // Добавляем в окно набор вкладок с параметрами заданными в гридере
        add(jTabbedPane, constraints);
    }
}