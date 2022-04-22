package ColorBox.Process;

import ColorBox.Process.BlockPanel.GapAndSelected;

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
            GapAndSelected gas = new GapAndSelected();

            add(gas.getLabX());
            add(gas.getInputX());
            add(gas.getTextX());

            add(gas.getLabY());
            add(gas.getInputY());
            add(gas.getTextY());

            add(gas.getLabZ());
            add(gas.getInputZ());
            add(gas.getTextZ());

            JLabel labF = new JLabel("Высота крышки F:");
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100, 30);
            add(textF);

            add(gas.getLabNumber());
            add(gas.getInputNumber());
            add(gas.getTextNumber());

            add(gas.getFlagText1());

            add(gas.getjComboBoxInside());

            add(gas.getFlagText2());

            add(gas.getjComboBoxPlastic());

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135, 395, 125, 58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = checkXYZGNumber(gas.getInputX(), gas.getTextX(), 30, 990);
                    boolean cY = checkXYZGNumber(gas.getInputY(), gas.getTextY(), 30, 690);
                    boolean cZ = checkXYZGNumber(gas.getInputZ(), gas.getTextZ(), 15, 450);
                    boolean cF = checkF(inputF, gas.getInputZ(), textF, 15, 450);
                    boolean cNumber = checkXYZGNumber(gas.getInputNumber(), gas.getTextNumber(), 5, 5000);
                    int now = selectedInside((String) gas.getjComboBoxInside().getSelectedItem());
                    int plasticSelected = selectedOutside((String) gas.getjComboBoxPlastic().getSelectedItem());
                    if (cX && cY && cZ && cF && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().Cap(
                                Integer.parseInt(gas.getInputX().getText()),
                                Integer.parseInt(gas.getInputY().getText()),
                                Integer.parseInt(gas.getInputZ().getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(gas.getInputNumber().getText()),
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
            GapAndSelected gas = new GapAndSelected();

            add(gas.getLabX());
            add(gas.getInputX());
            add(gas.getTextX());

            add(gas.getLabY());
            add(gas.getInputY());
            add(gas.getTextY());

            add(gas.getLabZ());
            add(gas.getInputZ());
            add(gas.getTextZ());

            add(gas.getLabNumber());
            add(gas.getInputNumber());
            add(gas.getTextNumber());

            JLabel labF = new JLabel("Высота клапана F:");
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100, 30);
            add(textF);

            add(gas.getLabNumber());
            add(gas.getInputNumber());
            add(gas.getTextNumber());

            add(gas.getFlagText1());

            add(gas.getjComboBoxInside());

            add(gas.getFlagText2());

            add(gas.getjComboBoxPlastic());

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135, 395, 125, 58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = checkXYZGNumber(gas.getInputX(), gas.getTextX(), 30, 450);
                    boolean cY = checkXYZGNumber(gas.getInputY(), gas.getTextY(), 30, 450);
                    boolean cZ = checkXYZGNumber(gas.getInputZ(), gas.getTextZ(), 30, 350);
                    boolean cF = checkF(inputF, gas.getInputZ(), textF, 15, 450);
                    boolean cNumber = checkXYZGNumber(gas.getInputNumber(), gas.getTextNumber(), 5, 5000);
                    int now = selectedInside((String) gas.getjComboBoxInside().getSelectedItem());
                    int plasticSelected = selectedOutside((String) gas.getjComboBoxPlastic().getSelectedItem());
                    if (cX && cY && cZ && cF && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().MagicG(
                                Integer.parseInt(gas.getInputX().getText()),
                                Integer.parseInt(gas.getInputY().getText()),
                                Integer.parseInt(gas.getInputZ().getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(gas.getInputNumber().getText()),
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

    class Pane3 extends JPanel {
        public Pane3() {
            setLayout(null);
            GapAndSelected gas = new GapAndSelected();

            add(gas.getLabX());
            add(gas.getInputX());
            add(gas.getTextX());

            add(gas.getLabY());
            add(gas.getInputY());
            add(gas.getTextY());

            add(gas.getLabZ());
            add(gas.getInputZ());
            add(gas.getTextZ());

            add(gas.getLabNumber());
            add(gas.getInputNumber());
            add(gas.getTextNumber());

            JLabel labF = new JLabel("Высота клапана F:");
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100, 30);
            add(textF);

            add(gas.getLabNumber());
            add(gas.getInputNumber());
            add(gas.getTextNumber());

            add(gas.getFlagText1());

            add(gas.getjComboBoxInside());

            add(gas.getFlagText2());

            add(gas.getjComboBoxPlastic());

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135, 395, 125, 58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = checkXYZGNumber(gas.getInputX(), gas.getTextX(), 30, 450);
                    boolean cY = checkXYZGNumber(gas.getInputY(), gas.getTextY(), 30, 450);
                    boolean cZ = checkXYZGNumber(gas.getInputZ(), gas.getTextZ(), 30, 350);
                    boolean cF = checkF(inputF, gas.getInputZ(), textF, 15, 450);
                    boolean cNumber = checkXYZGNumber(gas.getInputNumber(), gas.getTextNumber(), 5, 5000);
                    int now = selectedInside((String) gas.getjComboBoxInside().getSelectedItem());
                    int plasticSelected = selectedOutside((String) gas.getjComboBoxPlastic().getSelectedItem());
                    if (cX && cY && cZ && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().MagicV(
                                Integer.parseInt(gas.getInputX().getText()),
                                Integer.parseInt(gas.getInputY().getText()),
                                Integer.parseInt(gas.getInputZ().getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(gas.getInputNumber().getText()),
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

    class Pane4 extends JPanel {
        public Pane4() {
            setLayout(null);
            GapAndSelected gas = new GapAndSelected();

            add(gas.getLabX());
            add(gas.getInputX());
            add(gas.getTextX());

            add(gas.getLabY());
            add(gas.getInputY());
            add(gas.getTextY());


            add(gas.getLabZ());
            add(gas.getInputZ());
            add(gas.getTextZ());

            JLabel labF = new JLabel("Ширина боковой линии F:");
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100, 30);
            add(textF);

            add(gas.getLabNumber());
            add(gas.getInputNumber());
            add(gas.getTextNumber());

            add(gas.getLabNumber());
            add(gas.getInputNumber());
            add(gas.getTextNumber());

            add(gas.getFlagText1());

            add(gas.getjComboBoxInside());

            add(gas.getFlagText2());

            add(gas.getjComboBoxPlastic());

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135, 395, 125, 58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = checkXYZGNumber(gas.getInputX(), gas.getTextX(), 30, 990);
                    boolean cY = checkXYZGNumber(gas.getInputY(), gas.getTextY(), 30, 690);
                    boolean cZ = checkXYZGNumber(gas.getInputZ(), gas.getTextZ(), 15, 350);
                    boolean cF = checkF(inputF, gas.getInputZ(), textF, 0, 350);
                    boolean cNumber = checkXYZGNumber(gas.getInputNumber(), gas.getTextNumber(), 5, 5000);
                    int now = selectedInside((String) gas.getjComboBoxInside().getSelectedItem());
                    int plasticSelected = selectedOutside((String) gas.getjComboBoxPlastic().getSelectedItem());
                    if (cX && cY && cZ && cF && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().TwoCapLite(
                                Integer.parseInt(gas.getInputX().getText()),
                                Integer.parseInt(gas.getInputY().getText()),
                                Integer.parseInt(gas.getInputZ().getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(gas.getInputNumber().getText()),
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
                    && Integer.parseInt(text.getText()) <= (Integer.parseInt(text2.getText()) + 2)) {
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
