package ColorBox.Process.BlockPanel;

import javax.swing.*;

public class GapAndSelected extends JPanel {
    private JLabel labX = new JLabel("Длина коробки Х:");
    private JTextField inputX = new JTextField("", 20);
    private JLabel textX = new JLabel();

    private JLabel labY = new JLabel("Ширина коробки Y:");
    private JTextField inputY = new JTextField("", 20);
    private JLabel textY = new JLabel();

    private JLabel labZ = new JLabel("Высота коробки Z:");
    private JTextField inputZ = new JTextField("", 20);
    private JLabel textZ = new JLabel();

    private JLabel labNumber = new JLabel("Тираж:");
    private JTextField inputNumber = new JTextField("", 20);
    private JLabel textNumber = new JLabel();

    private JLabel flagText1 = new JLabel("Внутр. пленка");

    private JComboBox<String> jComboBoxInside = new JComboBox<>(new String[]{"Нет", "1/1,26", "DLC", "1,5"});

    private JLabel flagText2 = new JLabel("Наруж. пленка");

    private JComboBox<String> jComboBoxPlastic = new JComboBox<>(new String[]{"1/1,26", "DLC", "1,5"});


    public JLabel getLabNumber() {
        labNumber.setBounds(29, 265, 200, 54);
        return labNumber;
    }

    public JTextField getInputNumber() {
        inputNumber.setBounds(25, 303, 100, 30);
        return inputNumber;
    }

    public JLabel getTextNumber() {
        textNumber.setBounds(125, 303, 100, 30);
        return textNumber;
    }

    public JLabel getLabZ() {
        labZ.setBounds(29, 112, 200, 54);
        return labZ;
    }

    public JTextField getInputZ() {
        inputZ.setBounds(25, 150, 100, 30);
        return inputZ;
    }

    public JLabel getTextZ() {
        textZ.setBounds(125, 150, 100, 30);
        return textZ;
    }

    public JLabel getLabY() {
        labY.setBounds(29, 61, 200, 54);
        return labY;
    }

    public JTextField getInputY() {
        inputY.setBounds(25, 99, 100, 30);
        return inputY;
    }

    public JLabel getTextY() {
        textY.setBounds(125, 99, 100, 30);
        return textY;
    }

    public JLabel getLabX() {
        labX.setBounds(29, 10, 200, 54);
        return labX;
    }

    public JTextField getInputX() {
        inputX.setBounds(25, 48, 100, 30);
        return inputX;
    }

    public JLabel getTextX() {
        textX.setBounds(125, 48, 100, 30);
        return textX;
    }

    public JLabel getFlagText1() {
        flagText1.setBounds(29, 333, 200, 54);
        return flagText1;
    }

    public JComboBox<String> getjComboBoxInside() {
        jComboBoxInside.setBounds(23, 370, 105, 30);
        return jComboBoxInside;
    }

    public JLabel getFlagText2() {
        flagText2.setBounds(29, 388, 200, 54);
        return flagText2;
    }

    public JComboBox<String> getjComboBoxPlastic() {
        jComboBoxPlastic.setBounds(23, 425, 105, 30);
        return jComboBoxPlastic;
    }
}
