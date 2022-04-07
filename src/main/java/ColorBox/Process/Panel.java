package ColorBox.Process;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel extends JPanel {

    public Panel() {
        setLayout(new GridLayout());

        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        jTabbedPane.addTab("Крышка-дно", new Pane1());
        jTabbedPane.addTab("Шкатулка гор.", new Pane2());
        jTabbedPane.addTab("Шкатулка вер.", new Pane3());
        jTabbedPane.addTab("Двойное дно", new Pane4());
        jTabbedPane.addTab("Двойное дно (разный борт)", new Pane5());
        add(jTabbedPane);
    }

    class Pane1 extends JPanel {
        public Pane1() {
            setLayout(null);
            JLabel labX = new JLabel("Длина коробки Х:");
            labX.setBounds(29, 10, 200, 54);
            add(labX);
            JTextField inputX = new JTextField("", 20);
            inputX.setBounds(25, 48, 100, 30);
            add(inputX);
            JLabel textX = new JLabel();
            textX.setBounds(125, 48, 100, 30);
            add(textX);

            JLabel labY = new JLabel("Ширина коробки Y:");
            labY.setBounds(29, 61, 200, 54);
            add(labY);
            JTextField inputY = new JTextField("", 20);
            inputY.setBounds(25, 99, 100, 30);
            add(inputY);
            JLabel textY = new JLabel();
            textY.setBounds(125, 99, 100, 30);
            add(textY);

            JLabel labZ = new JLabel("Высота коробки Z:");
            labZ.setBounds(29, 112, 200, 54);
            add(labZ);
            JTextField inputZ = new JTextField("", 20);
            inputZ.setBounds(25, 150, 100, 30);
            add(inputZ);
            JLabel textZ = new JLabel();
            textZ.setBounds(125, 150, 100, 30);
            add(textZ);

            JLabel labF = new JLabel("Высота крышки F:");
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100, 30);
            add(textF);

            JLabel labNumber = new JLabel("Тираж:");
            labNumber.setBounds(29, 265, 200, 54);
            add(labNumber);
            JTextField inputNumber = new JTextField("", 20);
            inputNumber.setBounds(25, 303, 100, 30);
            add(inputNumber);
            JLabel textNumber = new JLabel();
            textNumber.setBounds(125, 303, 100, 30);
            add(textNumber);

            JLabel flagText1 = new JLabel("Внутр. пленка");
            flagText1.setBounds(29, 333, 200, 54);
            add(flagText1);

            JComboBox<String> jComboBoxInside = new JComboBox<>();
            jComboBoxInside.setBounds(23, 358, 105, 54);
            jComboBoxInside.addItem("Нет");
            jComboBoxInside.addItem("1/1,26");
            jComboBoxInside.addItem("DLC");
            jComboBoxInside.addItem("1,5");
            add(jComboBoxInside);

            JLabel flagText2 = new JLabel("Наруж. пленка");
            flagText2.setBounds(29, 388, 200, 54);
            add(flagText2);

            JComboBox<String> jComboBoxPlastic = new JComboBox<>();
            jComboBoxPlastic.setBounds(23, 413, 105, 54);
            jComboBoxPlastic.addItem("1/1,26");
            jComboBoxPlastic.addItem("DLC");
            jComboBoxPlastic.addItem("1,5");
            add(jComboBoxPlastic);

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135, 395, 125, 58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = checkXYZGNumber(inputX, textX, 30, 990);
                    boolean cY = checkXYZGNumber(inputY, textY, 30, 690);
                    boolean cZ = checkXYZGNumber(inputZ, textZ, 15, 350);
                    boolean cF = checkF(inputF, inputZ, textF, 15, 350);
                    boolean cNumber = checkXYZGNumber(inputNumber, textNumber, 5, 5000);
                    int now = selectedInside((String) jComboBoxInside.getSelectedItem());
                    int plasticSelected = selectedOutside((String) jComboBoxPlastic.getSelectedItem());
                    if (cX && cY && cZ && cF && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().Cap(
                                Integer.parseInt(inputX.getText()),
                                Integer.parseInt(inputY.getText()),
                                Integer.parseInt(inputZ.getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(inputNumber.getText()),
                                now,
                                plasticSelected
                        );
                        output.setText(That.ou);
                    } else {
                        output.setText("Ошибка ввода данных!");
                    }
                }
            });

            add(output);
            JScrollPane scrollPane = new JScrollPane(output);
            scrollPane.setBounds(275, 25, 375, 425);
            scrollPane.setPreferredSize(new Dimension(375, 425));
            add(scrollPane);
        }
    }

    class Pane2 extends JPanel {
        public Pane2() {
            setLayout(null);
            JLabel labX = new JLabel("Длина коробки Х:");
            labX.setBounds(29, 10, 200, 54);
            add(labX);
            JTextField inputX = new JTextField("", 20);
            inputX.setBounds(25, 48, 100, 30);
            add(inputX);
            JLabel textX = new JLabel();
            textX.setBounds(125, 48, 100, 30);
            add(textX);

            JLabel labY = new JLabel("Ширина коробки Y:");
            labY.setBounds(29, 61, 200, 54);
            add(labY);
            JTextField inputY = new JTextField("", 20);
            inputY.setBounds(25, 99, 100, 30);
            add(inputY);
            JLabel textY = new JLabel();
            textY.setBounds(125, 99, 100, 30);
            add(textY);

            JLabel labZ = new JLabel("Высота коробки Z:");
            labZ.setBounds(29, 112, 200, 54);
            add(labZ);
            JTextField inputZ = new JTextField("", 20);
            inputZ.setBounds(25, 150, 100, 30);
            add(inputZ);
            JLabel textZ = new JLabel();
            textZ.setBounds(125, 150, 100, 30);
            add(textZ);

            JLabel labNumber = new JLabel("Тираж:");
            labNumber.setBounds(29, 265, 200, 54);
            add(labNumber);
            JTextField inputNumber = new JTextField("", 20);
            inputNumber.setBounds(25, 303, 100, 30);
            add(inputNumber);
            JLabel textNumber = new JLabel();
            textNumber.setBounds(125, 303, 100, 30);
            add(textNumber);

            JLabel flagText1 = new JLabel("Оклейка");
            flagText1.setBounds(29, 335, 200, 54);
            add(flagText1);
            JLabel flagText2 = new JLabel("внутри");
            flagText2.setBounds(29, 353, 200, 54);
            add(flagText2);
            JCheckBox flag = new JCheckBox();
            flag.setBounds(90, 358, 30, 30);
            add(flag);

//            JComboBox<String> jComboBox = new JComboBox<>();
//            jComboBox.setBounds(25, 398, 100, 54);
//            jComboBox.addItem("1/1,26");
//            jComboBox.addItem("DLC");
//            jComboBox.addItem("1,5");
//            add(jComboBox);


            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135, 395, 125, 58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = checkXYZGNumber(inputX, textX, 30, 450);
                    boolean cY = checkXYZGNumber(inputY, textY, 30, 450);
                    boolean cZ = checkXYZGNumber(inputZ, textZ, 30, 350);
                    boolean cNumber = checkXYZGNumber(inputNumber, textNumber, 5, 5000);
                    boolean now = (flag.isSelected()) ? true : false;
                    if (cX && cY && cZ && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().MagicG(
                                Integer.parseInt(inputX.getText()),
                                Integer.parseInt(inputY.getText()),
                                Integer.parseInt(inputZ.getText()),
                                Integer.parseInt(inputNumber.getText()),
                                now
                        );
                        output.setText(That.ou);

                    } else {
                        output.setText("Ошибка ввода данных!");
                    }
                }
            });

            add(output);
            JScrollPane scrollPane = new JScrollPane(output);
            scrollPane.setBounds(275, 25, 375, 425);
            scrollPane.setPreferredSize(new Dimension(375, 425));
            add(scrollPane);
        }
    }

    class Pane3 extends JPanel {
        public Pane3() {
            setLayout(null);
            JLabel labX = new JLabel("Длина коробки Х:");
            labX.setBounds(29, 10, 200, 54);
            add(labX);
            JTextField inputX = new JTextField("", 20);
            inputX.setBounds(25, 48, 100, 30);
            add(inputX);
            JLabel textX = new JLabel();
            textX.setBounds(125, 48, 100, 30);
            add(textX);

            JLabel labY = new JLabel("Ширина коробки Y:");
            labY.setBounds(29, 61, 200, 54);
            add(labY);
            JTextField inputY = new JTextField("", 20);
            inputY.setBounds(25, 99, 100, 30);
            add(inputY);
            JLabel textY = new JLabel();
            textY.setBounds(125, 99, 100, 30);
            add(textY);

            JLabel labZ = new JLabel("Высота коробки Z:");
            labZ.setBounds(29, 112, 200, 54);
            add(labZ);
            JTextField inputZ = new JTextField("", 20);
            inputZ.setBounds(25, 150, 100, 30);
            add(inputZ);
            JLabel textZ = new JLabel();
            textZ.setBounds(125, 150, 100, 30);
            add(textZ);

            JLabel labNumber = new JLabel("Тираж:");
            labNumber.setBounds(29, 265, 200, 54);
            add(labNumber);
            JTextField inputNumber = new JTextField("", 20);
            inputNumber.setBounds(25, 303, 100, 30);
            add(inputNumber);
            JLabel textNumber = new JLabel();
            textNumber.setBounds(125, 303, 100, 30);
            add(textNumber);

            JLabel flagText1 = new JLabel("Оклейка");
            flagText1.setBounds(29, 335, 200, 54);
            add(flagText1);
            JLabel flagText2 = new JLabel("внутри");
            flagText2.setBounds(29, 353, 200, 54);
            add(flagText2);
            JCheckBox flag = new JCheckBox();
            flag.setBounds(90, 358, 30, 30);
            add(flag);

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135, 395, 125, 58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = checkXYZGNumber(inputX, textX, 30, 450);
                    boolean cY = checkXYZGNumber(inputY, textY, 30, 450);
                    boolean cZ = checkXYZGNumber(inputZ, textZ, 30, 350);
                    boolean cNumber = checkXYZGNumber(inputNumber, textNumber, 5, 5000);
                    boolean now = (flag.isSelected()) ? true : false;
                    if (cX && cY && cZ && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().MagicV(
                                Integer.parseInt(inputX.getText()),
                                Integer.parseInt(inputY.getText()),
                                Integer.parseInt(inputZ.getText()),
                                Integer.parseInt(inputNumber.getText()),
                                now
                        );
                        output.setText(That.ou);
                    } else {
                        output.setText("Ошибка ввода данных!");
                    }
                }
            });

            add(output);
            JScrollPane scrollPane = new JScrollPane(output);
            scrollPane.setBounds(275, 25, 375, 425);
            scrollPane.setPreferredSize(new Dimension(375, 425));
            add(scrollPane);
        }
    }

    class Pane4 extends JPanel {
        public Pane4() {
            setLayout(null);
            JLabel labX = new JLabel("Длина коробки Х:");
            labX.setBounds(29, 10, 200, 54);
            add(labX);
            JTextField inputX = new JTextField("", 20);
            inputX.setBounds(25, 48, 100, 30);
            add(inputX);
            JLabel textX = new JLabel();
            textX.setBounds(125, 48, 100, 30);
            add(textX);

            JLabel labY = new JLabel("Ширина коробки Y:");
            labY.setBounds(29, 61, 200, 54);
            add(labY);
            JTextField inputY = new JTextField("", 20);
            inputY.setBounds(25, 99, 100, 30);
            add(inputY);
            JLabel textY = new JLabel();
            textY.setBounds(125, 99, 100, 30);
            add(textY);

            JLabel labZ = new JLabel("Высота коробки Z:");
            labZ.setBounds(29, 112, 200, 54);
            add(labZ);
            JTextField inputZ = new JTextField("", 20);
            inputZ.setBounds(25, 150, 100, 30);
            add(inputZ);
            JLabel textZ = new JLabel();
            textZ.setBounds(125, 150, 100, 30);
            add(textZ);

            JLabel labF = new JLabel("Ширина боковой линии F:");
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100, 30);
            add(textF);

            JLabel labNumber = new JLabel("Тираж:");
            labNumber.setBounds(29, 265, 200, 54);
            add(labNumber);
            JTextField inputNumber = new JTextField("", 20);
            inputNumber.setBounds(25, 303, 100, 30);
            add(inputNumber);
            JLabel textNumber = new JLabel();
            textNumber.setBounds(125, 303, 100, 30);
            add(textNumber);

            JLabel flagText1 = new JLabel("Оклейка");
            flagText1.setBounds(29, 335, 200, 54);
            add(flagText1);
            JLabel flagText2 = new JLabel("внутри");
            flagText2.setBounds(29, 353, 200, 54);
            add(flagText2);
            JCheckBox flag = new JCheckBox();
            flag.setBounds(90, 358, 30, 30);
            add(flag);

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135, 395, 125, 58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = checkXYZGNumber(inputX, textX, 30, 450);
                    boolean cY = checkXYZGNumber(inputY, textY, 30, 450);
                    boolean cZ = checkXYZGNumber(inputZ, textZ, 30, 350);
                    boolean cF = checkF(inputF, inputZ, textF, 0, 350);
                    boolean cNumber = checkXYZGNumber(inputNumber, textNumber, 5, 5000);
                    boolean now = (flag.isSelected()) ? true : false;
                    if (cX && cY && cZ && cF && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().TwoCapLite(
                                Integer.parseInt(inputX.getText()),
                                Integer.parseInt(inputY.getText()),
                                Integer.parseInt(inputZ.getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(inputNumber.getText()),
                                now
                        );
                        output.setText(That.ou);
                    } else {
                        output.setText("Ошибка ввода данных!");
                    }
                }
            });

            add(output);
            JScrollPane scrollPane = new JScrollPane(output);
            scrollPane.setBounds(275, 25, 375, 425);
            scrollPane.setPreferredSize(new Dimension(375, 425));
            add(scrollPane);

        }
    }

    class Pane5 extends JPanel {
        public Pane5() {
        }
    }

    private boolean checkXYZGNumber(JTextField text, JLabel o, int one, int two) {
        try {
            if (Integer.parseInt(text.getText()) >= one && Integer.parseInt(text.getText()) <= two) {
                o.setText("ok");
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception exception) {
            o.setText("от " + one + " до " + two);
            return false;
        }
    }

    private boolean checkF(JTextField text, JTextField text2, JLabel o, int one, int two) {
        try {
            if (Integer.parseInt(text.getText()) >= one
                    && Integer.parseInt(text.getText()) <= two
                    && Integer.parseInt(text.getText()) <= Integer.parseInt(text2.getText() + 2)) {
                o.setText("ok");
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception exception) {
            o.setText("от " + one + " до " + two);
            return false;
        }
    }

    private int selectedInside(String line) {
        switch (line) {
            case "1/1,26":
                return 1;
            case "DLC":
                return 2;
            case "1,5":
                return 3;
            default:
                return 0;
        }
    }

    private int selectedOutside(String line) {
        switch (line) {
            case "DLC":
                return 0;
            case "1,5":
                return 1;
            default:
                return -1;
        }
    }
}
