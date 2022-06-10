package ColorBox.Frontend;

import ColorBox.Frontend.BlockPanel.*;
import ColorBox.Frontend.Menu.UpMenuBar;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel() {
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.gridy = 0;

        add(new UpMenuBar().getBar(), constraints);

        constraints.gridy = 1;
        constraints.weighty = 325;
        constraints.ipady = 600;

        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        jTabbedPane.addTab("Крышка-дно", new PaneCap());
        jTabbedPane.addTab("Шкатулка гор.", new PaneMagicG());
        jTabbedPane.addTab("Шкатулка вер.", new PaneMagicV());
        jTabbedPane.addTab("Двойное дно", new PaneTwoCapLite());
        jTabbedPane.addTab("Двойное дно (разный борт)", new PaneTwoCap());

        add(jTabbedPane, constraints);
    }
}