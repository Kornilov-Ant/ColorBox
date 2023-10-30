package ColorBox.Frontend.BlockPanel;

import ColorBox.Backend.Controller.BoxController;

import javax.swing.*;

/**
 *  Родительский класс, имеющий в себе главные элементы,
 *  которые должны присутствовать в каждой вкладке
 */
public class Pane extends JPanel {

    // Объект, в котором есть все общие требуемые элементы
    // для будущего окна приложения
    protected GapAndSelected gas;

    protected final BoxController controller = new BoxController();

    public Pane() {
        gas = new GapAndSelected();
        setLayout(null);

        // Добавляются объекты
        // группы "Длинна коробки"
        add(gas.getLabX());
        add(gas.getInputX());
        add(gas.getTextX());

        // Добавляются объекты
        // группы "Ширина коробки"
        add(gas.getLabY());
        add(gas.getInputY());
        add(gas.getTextY());

        // Добавляются объекты
        // группы "Высота коробки"
        add(gas.getLabZ());
        add(gas.getInputZ());
        add(gas.getTextZ());

        // Объекты с опцией
        // "оклейка внутри"
        add(gas.getFlagText1());
        add(gas.getJComboBoxInside());

        // Объекты с опцией
        // "оклейка снаружи"
        add(gas.getFlagText2());
        add(gas.getJComboBoxPlastic());

        // Добавляются объекты
        // группы "Тираж"
        add(gas.getLabNumber());
        add(gas.getInputNumber());
        add(gas.getTextNumber());

        // добавление кнопки "посчитать"
        add(gas.getB1());
    }
}
