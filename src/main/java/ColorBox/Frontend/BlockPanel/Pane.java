package ColorBox.Frontend.BlockPanel;

import javax.swing.*;

public class Pane extends JPanel {

    protected GapAndSelected gas;

    public Pane() {
        gas = new GapAndSelected();
        setLayout(null);

        add(gas.getLabX());
        add(gas.getInputX());
        add(gas.getTextX());

        add(gas.getLabY());
        add(gas.getInputY());
        add(gas.getTextY());

        add(gas.getLabZ());
        add(gas.getInputZ());
        add(gas.getTextZ());

        add(gas.getFlagText1());
        add(gas.getjComboBoxInside());

        add(gas.getFlagText2());
        add(gas.getjComboBoxPlastic());

        add(gas.getLabNumber());
        add(gas.getInputNumber());
        add(gas.getTextNumber());

        add(gas.getB1()); // кнопка "посчитать"
    }
}
