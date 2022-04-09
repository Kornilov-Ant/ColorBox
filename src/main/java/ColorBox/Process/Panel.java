package ColorBox.Process;

import ColorBox.Process.BlockPanel.XYZNumber;

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
            XYZNumber xyzNumber = new XYZNumber();

            add(xyzNumber.getLabX());
            add(xyzNumber.getInputX());
            add(xyzNumber.getTextX());

            add(xyzNumber.getLabY());
            add(xyzNumber.getInputY());
            add(xyzNumber.getTextY());

            add(xyzNumber.getLabZ());
            add(xyzNumber.getInputZ());
            add(xyzNumber.getTextZ());

            JLabel labF = new JLabel("Высота крышки F:");
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100, 30);
            add(textF);

            add(xyzNumber.getLabNumber());
            add(xyzNumber.getInputNumber());
            add(xyzNumber.getTextNumber());

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
                    boolean cX = checkXYZGNumber(xyzNumber.getInputX(), xyzNumber.getTextX(), 30, 990);
                    boolean cY = checkXYZGNumber(xyzNumber.getInputY(), xyzNumber.getTextY(), 30, 690);
                    boolean cZ = checkXYZGNumber(xyzNumber.getInputZ(), xyzNumber.getTextZ(), 15, 350);
                    boolean cF = checkF(inputF, xyzNumber.getInputZ(), textF, 15, 350);
                    boolean cNumber = checkXYZGNumber(xyzNumber.getInputNumber(), xyzNumber.getTextNumber(), 5, 5000);
                    int now = selectedInside((String) jComboBoxInside.getSelectedItem());
                    int plasticSelected = selectedOutside((String) jComboBoxPlastic.getSelectedItem());
                    if (cX && cY && cZ && cF && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().Cap(
                                Integer.parseInt(xyzNumber.getInputX().getText()),
                                Integer.parseInt(xyzNumber.getInputY().getText()),
                                Integer.parseInt(xyzNumber.getInputZ().getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(xyzNumber.getInputNumber().getText()),
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
            XYZNumber xyzNumber = new XYZNumber();

            add(xyzNumber.getLabX());
            add(xyzNumber.getInputX());
            add(xyzNumber.getTextX());

            add(xyzNumber.getLabY());
            add(xyzNumber.getInputY());
            add(xyzNumber.getTextY());

            add(xyzNumber.getLabZ());
            add(xyzNumber.getInputZ());
            add(xyzNumber.getTextZ());

            add(xyzNumber.getLabNumber());
            add(xyzNumber.getInputNumber());
            add(xyzNumber.getTextNumber());

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
                    boolean cX = checkXYZGNumber(xyzNumber.getInputX(), xyzNumber.getTextX(), 30, 450);
                    boolean cY = checkXYZGNumber(xyzNumber.getInputY(), xyzNumber.getTextY(), 30, 450);
                    boolean cZ = checkXYZGNumber(xyzNumber.getInputZ(), xyzNumber.getTextZ(), 30, 350);
                    boolean cNumber = checkXYZGNumber(xyzNumber.getInputNumber(), xyzNumber.getTextNumber(), 5, 5000);
                    boolean now = (flag.isSelected()) ? true : false;
                    if (cX && cY && cZ && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().MagicG(
                                Integer.parseInt(xyzNumber.getInputX().getText()),
                                Integer.parseInt(xyzNumber.getInputY().getText()),
                                Integer.parseInt(xyzNumber.getInputZ().getText()),
                                Integer.parseInt(xyzNumber.getInputNumber().getText()),
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
            XYZNumber xyzNumber = new XYZNumber();

            add(xyzNumber.getLabX());
            add(xyzNumber.getInputX());
            add(xyzNumber.getTextX());

            add(xyzNumber.getLabY());
            add(xyzNumber.getInputY());
            add(xyzNumber.getTextY());

            add(xyzNumber.getLabZ());
            add(xyzNumber.getInputZ());
            add(xyzNumber.getTextZ());

            add(xyzNumber.getLabNumber());
            add(xyzNumber.getInputNumber());
            add(xyzNumber.getTextNumber());

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
                    boolean cX = checkXYZGNumber(xyzNumber.getInputX(), xyzNumber.getTextX(), 30, 450);
                    boolean cY = checkXYZGNumber(xyzNumber.getInputY(), xyzNumber.getTextY(), 30, 450);
                    boolean cZ = checkXYZGNumber(xyzNumber.getInputZ(), xyzNumber.getTextZ(), 30, 350);
                    boolean cNumber = checkXYZGNumber(xyzNumber.getInputNumber(), xyzNumber.getTextNumber(), 5, 5000);
                    boolean now = (flag.isSelected()) ? true : false;
                    if (cX && cY && cZ && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().MagicV(
                                Integer.parseInt(xyzNumber.getInputX().getText()),
                                Integer.parseInt(xyzNumber.getInputY().getText()),
                                Integer.parseInt(xyzNumber.getInputZ().getText()),
                                Integer.parseInt(xyzNumber.getInputNumber().getText()),
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
            XYZNumber xyzNumber = new XYZNumber();

            add(xyzNumber.getLabX());
            add(xyzNumber.getInputX());
            add(xyzNumber.getTextX());

            add(xyzNumber.getLabY());
            add(xyzNumber.getInputY());
            add(xyzNumber.getTextY());


            add(xyzNumber.getLabZ());
            add(xyzNumber.getInputZ());
            add(xyzNumber.getTextZ());

            JLabel labF = new JLabel("Ширина боковой линии F:");
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100, 30);
            add(textF);

            add(xyzNumber.getLabNumber());
            add(xyzNumber.getInputNumber());
            add(xyzNumber.getTextNumber());

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
                    boolean cX = checkXYZGNumber(xyzNumber.getInputX(), xyzNumber.getTextX(), 30, 990);
                    boolean cY = checkXYZGNumber(xyzNumber.getInputY(), xyzNumber.getTextY(), 30, 690);
                    boolean cZ = checkXYZGNumber(xyzNumber.getInputZ(), xyzNumber.getTextZ(), 15, 350);
                    boolean cF = checkF(inputF, xyzNumber.getInputZ(), textF, 0, 350);
                    boolean cNumber = checkXYZGNumber(xyzNumber.getInputNumber(), xyzNumber.getTextNumber(), 5, 5000);
                    boolean now = (flag.isSelected()) ? true : false;
                    if (cX && cY && cZ && cF && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().TwoCapLite(
                                Integer.parseInt(xyzNumber.getInputX().getText()),
                                Integer.parseInt(xyzNumber.getInputY().getText()),
                                Integer.parseInt(xyzNumber.getInputZ().getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(xyzNumber.getInputNumber().getText()),
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
