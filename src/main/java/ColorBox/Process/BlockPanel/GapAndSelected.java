package ColorBox.Process.BlockPanel;

import javax.swing.*;

public class GapAndSelected extends JPanel {
    private JLabel labX = new JLabel("<html><b>Длина коробки Х:<b>");
    private JTextField inputX = new JTextField("", 20);
    private JLabel textX = new JLabel("\u21e0");

    private JLabel labY = new JLabel("<html><b>Ширина коробки Y:<b>");
    private JTextField inputY = new JTextField("", 20);
    private JLabel textY = new JLabel("\u21e0");

    private JLabel labZ = new JLabel("<html><b>Высота коробки Z:<b>");
    private JTextField inputZ = new JTextField("", 20);
    private JLabel textZ = new JLabel("\u21e0");

    private JLabel labNumber = new JLabel("<html><b>Тираж:<b>");
    private JTextField inputNumber = new JTextField("", 20);
    private JLabel textNumber = new JLabel("\u21e0");

    private JLabel flagText1 = new JLabel("<html><b>Внутр. пленка<b>");

    private JComboBox<String> jComboBoxInside = new JComboBox<>(new String[]{"Нет", "1/1,26", "DLC", "1,5"});

    private JLabel flagText2 = new JLabel("<html><b>Наруж. пленка<b>");

    private JComboBox<String> jComboBoxPlastic = new JComboBox<>(new String[]{"1/1,26", "DLC", "1,5"});

    private JButton b1 = new JButton("<html><b>Посчитать!<b>");

    public JButton getB1() {
        b1.setBounds(145, 495, 115, 58);
        return b1;
    }

    public JLabel getLabNumber() {
        labNumber.setBounds(29, 365, 200, 54);
        return labNumber;
    }

    public JTextField getInputNumber() {
        inputNumber.setBounds(25, 403, 100, 30);
        return inputNumber;
    }

    public JLabel getTextNumber() {
        textNumber.setBounds(125, 403, 100, 30);
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
        flagText1.setBounds(29, 433, 200, 54);
        return flagText1;
    }

    public JComboBox<String> getjComboBoxInside() {
        jComboBoxInside.setBounds(23, 470, 105, 30);
        return jComboBoxInside;
    }

    public JLabel getFlagText2() {
        flagText2.setBounds(29, 488, 200, 54);
        return flagText2;
    }

    public JComboBox<String> getjComboBoxPlastic() {
        jComboBoxPlastic.setBounds(23, 525, 105, 30);
        return jComboBoxPlastic;
    }
}
