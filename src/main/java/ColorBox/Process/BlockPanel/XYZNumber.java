package ColorBox.Process.BlockPanel;

import javax.swing.*;

public class XYZNumber extends JPanel {
    protected JLabel labX = new JLabel("Длина коробки Х:");
    protected JTextField inputX = new JTextField("", 20);
    protected JLabel textX = new JLabel();

    protected JLabel labY = new JLabel("Ширина коробки Y:");
    protected JTextField inputY = new JTextField("", 20);
    protected JLabel textY = new JLabel();

    protected JLabel labZ = new JLabel("Высота коробки Z:");
    protected JTextField inputZ = new JTextField("", 20);
    protected JLabel textZ = new JLabel();

    protected JLabel labNumber = new JLabel("Тираж:");
    protected JTextField inputNumber = new JTextField("", 20);
    protected JLabel textNumber = new JLabel();

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
}
