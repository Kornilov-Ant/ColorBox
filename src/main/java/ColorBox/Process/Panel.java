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

            JLabel labF = new JLabel("<html><b>Высота крышки F:<b>");
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

            add(gas.getB1()); // кнопка "посчитать"

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            gas.getB1().addActionListener(new ActionListener() {
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
            scrollPane.setBounds(275, 25, 375, 525);
            scrollPane.setPreferredSize(new Dimension(375, 525));
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

            JLabel labF = new JLabel("<html><b>Высота клапана F:<b>");
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

            add(gas.getB1()); // кнопка "посчитать"

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            gas.getB1().addActionListener(new ActionListener() {
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
            scrollPane.setBounds(275, 25, 375, 525);
            scrollPane.setPreferredSize(new Dimension(375, 525));
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

            JLabel labF = new JLabel("<html><b>Высота клапана F:<b>");
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

            add(gas.getB1()); // кнопка "посчитать"

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            gas.getB1().addActionListener(new ActionListener() {
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
            scrollPane.setBounds(275, 25, 375, 525);
            scrollPane.setPreferredSize(new Dimension(375, 525));
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

            JLabel labF = new JLabel("<html><b>Ширина боковой линии F:<b>");
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

            add(gas.getB1()); // кнопка "посчитать"

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            gas.getB1().addActionListener(new ActionListener() {
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
            scrollPane.setBounds(275, 25, 375, 525);
            scrollPane.setPreferredSize(new Dimension(375, 525));
            add(scrollPane);

        }
    }

    class Pane5 extends JPanel {
        public Pane5() {
            setLayout(null);
            GapAndSelected gas = new GapAndSelected();

            add(gas.getLabX());
            add(gas.getInputX());
            add(gas.getTextX());  // ширина

            add(gas.getLabY());
            add(gas.getInputY());
            add(gas.getTextY());  // длина


            add(gas.getLabZ());
            add(gas.getInputZ());
            add(gas.getTextZ());  // высота

            JLabel labF = new JLabel("<html><b>Внутренний борт F:<b>"); // высота части внутри
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100, 30);
            add(textF);

            JLabel labG = new JLabel("<html><b>Борт низ G:<b>"); // внешний нижний борт, высота
            labG.setBounds(29, 214, 200, 54);
            add(labG);
            JTextField inputG = new JTextField("", 20);
            inputG.setBounds(25, 252, 100, 30);
            add(inputG);
            JLabel textG = new JLabel();
            textG.setBounds(125, 252, 100, 30);
            add(textG);

            JLabel labH = new JLabel("<html><b>Ширина боковой линии H:<b>"); // требуемая ширина полосы между крышками
            labH.setBounds(29, 265, 200, 54);
            add(labH);
            JTextField inputH = new JTextField("", 20);
            inputH.setBounds(25, 303, 100, 30);
            add(inputH);
            JLabel textH = new JLabel();
            textH.setBounds(125, 303, 100, 30);
            add(textH);

            add(gas.getLabNumber());
            add(gas.getInputNumber());
            add(gas.getTextNumber());

            add(gas.getLabNumber());
            add(gas.getInputNumber());

            add(gas.getFlagText1());

            add(gas.getjComboBoxInside());

            add(gas.getFlagText2());

            add(gas.getjComboBoxPlastic());

            add(gas.getB1()); // кнопка "посчитать"

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            gas.getB1().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = checkXYZGNumber(gas.getInputX(), gas.getTextX(), 30, 990);
                    boolean cY = checkXYZGNumber(gas.getInputY(), gas.getTextY(), 30, 690);
                    boolean cZ = checkXYZGNumber(gas.getInputZ(), gas.getTextZ(), 15, 350);

                    boolean cF = checkF(inputF, gas.getInputZ(), textF, 0, 350);
                    boolean cG = checkG(inputG, inputF, textG, 0, 350);
                    boolean cH = checkH(inputH, gas.getInputZ(), inputG, textH, 0, 350);

                    boolean cNumber = checkXYZGNumber(gas.getInputNumber(), gas.getTextNumber(), 5, 5000);
                    int now = selectedInside((String) gas.getjComboBoxInside().getSelectedItem());
                    int plasticSelected = selectedOutside((String) gas.getjComboBoxPlastic().getSelectedItem());
                    if (cX && cY && cZ && cF && cG && cH && cNumber) {
                        That.ou = "";
                        That.list = new ArrayList<>();
                        new That().TwoCap(
                                Integer.parseInt(gas.getInputX().getText()),
                                Integer.parseInt(gas.getInputY().getText()),
                                Integer.parseInt(gas.getInputZ().getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(inputG.getText()),
                                Integer.parseInt(inputH.getText()),
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
            scrollPane.setBounds(275, 25, 375, 525);
            scrollPane.setPreferredSize(new Dimension(375, 525));
            add(scrollPane);

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
        } catch (Exception exc) {
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
        } catch (Exception exc) {
            if (Integer.parseInt(text.getText()) > (Integer.parseInt(text2.getText()) + 2)) {
                o.setText("Всегда меньше Z: <" + Integer.parseInt(text2.getText()));
                return false;
            } else {
                o.setText("от " + one + " до " + two);
                return false;
            }
        }
    }

    private boolean checkG(JTextField text, JTextField text2, JLabel o, int one, int two) {
        try {
            if (Integer.parseInt(text.getText()) >= one
                    && Integer.parseInt(text.getText()) <= two
                    && Integer.parseInt(text.getText()) <= (Integer.parseInt(text2.getText()) + 2)) {
                o.setText("ok");
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception exc) {
            o.setText("от " + one + " до " + two);
            return false;
        }
    }

    private boolean checkH(JTextField text, JTextField text2, JTextField text3, JLabel o, int one, int two) {
        try {
            if (Integer.parseInt(text.getText()) >= one
                    && Integer.parseInt(text.getText()) <= two
                    && Integer.parseInt(text.getText()) <= ((Integer.parseInt(text2.getText()) + 2)
                    - Integer.parseInt(text3.getText()))) {
                o.setText("ok");
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception exc) {
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
