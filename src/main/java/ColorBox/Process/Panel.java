package ColorBox.Process;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {

    public Panel(){
        setLayout(new GridLayout());

        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        jTabbedPane.addTab("Крышка-дно", new pane1());
        jTabbedPane.addTab("Шкатулка гор.", new pane2());
        jTabbedPane.addTab("Шкатулка вер.", new pane3());
        jTabbedPane.addTab("Двойное дно", new pane4());
        jTabbedPane.addTab("Двойное дно (разный борт)", new pane5());
        add(jTabbedPane);
    }

    class pane1 extends JPanel{
        public pane1(){
            setLayout(null);
            JLabel labX = new JLabel("Длина коробки Х:");
            labX.setBounds(29, 10, 200, 54);
            add(labX);
            JTextField inputX = new JTextField("0", 20);
            inputX.setBounds(25, 48, 100, 30);
            add(inputX);
            JLabel textX = new JLabel();
            textX.setBounds(125, 48, 100,30);
            add(textX);

            JLabel labY = new JLabel("Ширина коробки Y:");
            labY.setBounds(29, 61, 200, 54);
            add(labY);
            JTextField inputY = new JTextField("0", 20);
            inputY.setBounds(25, 99, 100, 30);
            add(inputY);
            JLabel textY = new JLabel();
            textY.setBounds(125, 99, 100,30);
            add(textY);

            JLabel labZ = new JLabel("Высота коробки Z:");
            labZ.setBounds(29, 112, 200, 54);
            add(labZ);
            JTextField inputZ = new JTextField("0", 20);
            inputZ.setBounds(25, 150, 100, 30);
            add(inputZ);
            JLabel textZ = new JLabel();
            textZ.setBounds(125, 150, 100,30);
            add(textZ);

            JLabel labF = new JLabel("Высота крышки F:");
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("0", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100,30);
            add(textF);

            JLabel labNumber = new JLabel("Тираж:");
            labNumber.setBounds(29, 265, 200, 54);
            add(labNumber);
            JTextField inputNumber = new JTextField("0", 20);
            inputNumber.setBounds(25, 303, 100, 30);
            add(inputNumber);
            JLabel textNumber = new JLabel();
            textNumber.setBounds(125, 303, 100,30);
            add(textNumber);

            JLabel flagText1 = new JLabel("Оклейка");
            flagText1.setBounds(29, 335, 200, 54);
            add(flagText1);
            JLabel flagText2 = new JLabel("внутри");
            flagText2.setBounds(29, 353, 200, 54);
            add(flagText2);
            JCheckBox flag = new JCheckBox();
            flag.setBounds(90, 358,30,30);
            add(flag);

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135,345,125,58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = CheckXYZGNumber(inputX, textX, 30, 990);
                    boolean cY = CheckXYZGNumber(inputY, textY, 30, 690);
                    boolean cZ = CheckXYZGNumber(inputZ, textZ, 20, 350);
                    boolean cF = CheckF(inputF, inputZ, textF, 15, 350);
                    boolean cNumber=CheckXYZGNumber(inputNumber,textNumber,10,5000);
                    boolean now = (flag.isSelected()) ? true : false;
                    if (cX && cY && cZ && cF && cNumber){
                        new That().Cap(
                                Integer.parseInt(inputX.getText()),
                                Integer.parseInt(inputY.getText()),
                                Integer.parseInt(inputZ.getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(inputNumber.getText()),
                                now
                        );

                        output.setText(That.ou);
                        That.ou = "";
                        That.list.clear();
                    } else {
                    output.setText("Ошибка ввода данных!");
                    }
                }
            });

            add(output);
            JScrollPane scrollPane = new JScrollPane(output);
            scrollPane.setBounds(275, 25, 375,375);
            scrollPane.setPreferredSize(new Dimension(375,375));
            add(scrollPane);
        }
    }
    class pane2 extends JPanel{
        public pane2(){
            setLayout(null);
            JLabel labX = new JLabel("Длина коробки Х:");
            labX.setBounds(29, 10, 200, 54);
            add(labX);
            JTextField inputX = new JTextField("0", 20);
            inputX.setBounds(25, 48, 100, 30);
            add(inputX);
            JLabel textX = new JLabel();
            textX.setBounds(125, 48, 100,30);
            add(textX);

            JLabel labY = new JLabel("Ширина коробки Y:");
            labY.setBounds(29, 61, 200, 54);
            add(labY);
            JTextField inputY = new JTextField("0", 20);
            inputY.setBounds(25, 99, 100, 30);
            add(inputY);
            JLabel textY = new JLabel();
            textY.setBounds(125, 99, 100,30);
            add(textY);

            JLabel labZ = new JLabel("Высота коробки Z:");
            labZ.setBounds(29, 112, 200, 54);
            add(labZ);
            JTextField inputZ = new JTextField("0", 20);
            inputZ.setBounds(25, 150, 100, 30);
            add(inputZ);
            JLabel textZ = new JLabel();
            textZ.setBounds(125, 150, 100,30);
            add(textZ);

            JLabel labNumber = new JLabel("Тираж:");
            labNumber.setBounds(29, 265, 200, 54);
            add(labNumber);
            JTextField inputNumber = new JTextField("0", 20);
            inputNumber.setBounds(25, 303, 100, 30);
            add(inputNumber);
            JLabel textNumber = new JLabel();
            textNumber.setBounds(125, 303, 100,30);
            add(textNumber);

            JLabel flagText1 = new JLabel("Оклейка");
            flagText1.setBounds(29, 335, 200, 54);
            add(flagText1);
            JLabel flagText2 = new JLabel("внутри");
            flagText2.setBounds(29, 353, 200, 54);
            add(flagText2);
            JCheckBox flag = new JCheckBox();
            flag.setBounds(90, 358,30,30);
            add(flag);

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135,345,125,58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = CheckXYZGNumber(inputX, textX, 30, 450);
                    boolean cY = CheckXYZGNumber(inputY, textY, 30, 450);
                    boolean cZ = CheckXYZGNumber(inputZ, textZ, 30, 350);
                    boolean cNumber=CheckXYZGNumber(inputNumber,textNumber,10,5000);
                    boolean now = (flag.isSelected()) ? true : false;
                    if (cX && cY && cZ && cNumber){
                        new That().MagicG(
                                Integer.parseInt(inputX.getText()),
                                Integer.parseInt(inputY.getText()),
                                Integer.parseInt(inputZ.getText()),
                                Integer.parseInt(inputNumber.getText()),
                                now
                        );

                        output.setText(That.ou);
                        That.ou = "";
                        That.list.clear();
                    } else {
                    output.setText("Ошибка ввода данных!");
                    }
                }
            });

            add(output);
            JScrollPane scrollPane = new JScrollPane(output);
            scrollPane.setBounds(275, 25, 375,375);
            scrollPane.setPreferredSize(new Dimension(375,375));
            add(scrollPane);
        }
    }
    class pane3 extends JPanel{
        public pane3() {
            setLayout(null);
            JLabel labX = new JLabel("Длина коробки Х:");
            labX.setBounds(29, 10, 200, 54);
            add(labX);
            JTextField inputX = new JTextField("0", 20);
            inputX.setBounds(25, 48, 100, 30);
            add(inputX);
            JLabel textX = new JLabel();
            textX.setBounds(125, 48, 100, 30);
            add(textX);

            JLabel labY = new JLabel("Ширина коробки Y:");
            labY.setBounds(29, 61, 200, 54);
            add(labY);
            JTextField inputY = new JTextField("0", 20);
            inputY.setBounds(25, 99, 100, 30);
            add(inputY);
            JLabel textY = new JLabel();
            textY.setBounds(125, 99, 100, 30);
            add(textY);

            JLabel labZ = new JLabel("Высота коробки Z:");
            labZ.setBounds(29, 112, 200, 54);
            add(labZ);
            JTextField inputZ = new JTextField("0", 20);
            inputZ.setBounds(25, 150, 100, 30);
            add(inputZ);
            JLabel textZ = new JLabel();
            textZ.setBounds(125, 150, 100, 30);
            add(textZ);

            JLabel labNumber = new JLabel("Тираж:");
            labNumber.setBounds(29, 265, 200, 54);
            add(labNumber);
            JTextField inputNumber = new JTextField("0", 20);
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
            flag.setBounds(90, 358,30,30);
            add(flag);

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135, 345, 125, 58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = CheckXYZGNumber(inputX, textX, 30, 450);
                    boolean cY = CheckXYZGNumber(inputY, textY, 30, 450);
                    boolean cZ = CheckXYZGNumber(inputZ, textZ, 30, 350);
                    boolean cNumber = CheckXYZGNumber(inputNumber, textNumber, 10, 5000);
                    boolean now = (flag.isSelected()) ? true : false;
                    if (cX && cY && cZ && cNumber) {
                        new That().MagicV(
                                Integer.parseInt(inputX.getText()),
                                Integer.parseInt(inputY.getText()),
                                Integer.parseInt(inputZ.getText()),
                                Integer.parseInt(inputNumber.getText()),
                                now
                        );

                        output.setText(That.ou);
                        That.ou = "";
                        That.list.clear();
                    } else {
                        output.setText("Ошибка ввода данных!");
                    }
                }
            });

            add(output);
            JScrollPane scrollPane = new JScrollPane(output);
            scrollPane.setBounds(275, 25, 375,375);
            scrollPane.setPreferredSize(new Dimension(375,375));
            add(scrollPane);
        }
    }
    class pane4 extends JPanel{
        public pane4(){
            setLayout(null);
            JLabel labX = new JLabel("Длина коробки Х:");
            labX.setBounds(29, 10, 200, 54);
            add(labX);
            JTextField inputX = new JTextField("0", 20);
            inputX.setBounds(25, 48, 100, 30);
            add(inputX);
            JLabel textX = new JLabel();
            textX.setBounds(125, 48, 100,30);
            add(textX);

            JLabel labY = new JLabel("Ширина коробки Y:");
            labY.setBounds(29, 61, 200, 54);
            add(labY);
            JTextField inputY = new JTextField("0", 20);
            inputY.setBounds(25, 99, 100, 30);
            add(inputY);
            JLabel textY = new JLabel();
            textY.setBounds(125, 99, 100,30);
            add(textY);

            JLabel labZ = new JLabel("Высота коробки Z:");
            labZ.setBounds(29, 112, 200, 54);
            add(labZ);
            JTextField inputZ = new JTextField("0", 20);
            inputZ.setBounds(25, 150, 100, 30);
            add(inputZ);
            JLabel textZ = new JLabel();
            textZ.setBounds(125, 150, 100,30);
            add(textZ);

            JLabel labF = new JLabel("Ширина боковой линии F:");
            labF.setBounds(29, 163, 200, 54);
            add(labF);
            JTextField inputF = new JTextField("0", 20);
            inputF.setBounds(25, 201, 100, 30);
            add(inputF);
            JLabel textF = new JLabel();
            textF.setBounds(125, 201, 100,30);
            add(textF);

            JLabel labNumber = new JLabel("Тираж:");
            labNumber.setBounds(29, 265, 200, 54);
            add(labNumber);
            JTextField inputNumber = new JTextField("0", 20);
            inputNumber.setBounds(25, 303, 100, 30);
            add(inputNumber);
            JLabel textNumber = new JLabel();
            textNumber.setBounds(125, 303, 100,30);
            add(textNumber);

            JLabel flagText1 = new JLabel("Оклейка");
            flagText1.setBounds(29, 335, 200, 54);
            add(flagText1);
            JLabel flagText2 = new JLabel("внутри");
            flagText2.setBounds(29, 353, 200, 54);
            add(flagText2);
            JCheckBox flag = new JCheckBox();
            flag.setBounds(90, 358,30,30);
            add(flag);

            JButton b1 = new JButton("Посчитать!");
            b1.setBounds(135,345,125,58);
            add(b1);

            JTextArea output = new JTextArea(5, 20);
            output.setEditable(false);

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cX = CheckXYZGNumber(inputX, textX, 30, 450);
                    boolean cY = CheckXYZGNumber(inputY, textY, 30, 450);
                    boolean cZ = CheckXYZGNumber(inputZ, textZ, 30, 350);
                    boolean cF = CheckF(inputF, inputZ, textF, 2, 350);
                    boolean cNumber=CheckXYZGNumber(inputNumber,textNumber,10,5000);
                    boolean now = (flag.isSelected()) ? true : false;
                    if (cX && cY && cZ && cF && cNumber){
                        new That().Cap(
                                Integer.parseInt(inputX.getText()),
                                Integer.parseInt(inputY.getText()),
                                Integer.parseInt(inputZ.getText()),
                                Integer.parseInt(inputF.getText()),
                                Integer.parseInt(inputNumber.getText()),
                                now
                        );

                        output.setText(That.ou);
                        That.ou = "";
                        That.list.clear();
                    } else {
                        output.setText("Ошибка ввода данных!");
                    }
                }
            });

            add(output);
            JScrollPane scrollPane = new JScrollPane(output);
            scrollPane.setBounds(275, 25, 375,375);
            scrollPane.setPreferredSize(new Dimension(375,375));
            add(scrollPane);

        }
    }
    class pane5 extends JPanel{
        public pane5(){
        }
    }

        public boolean CheckXYZGNumber(JTextField text, JLabel o, int one, int two){
            try {
                if (Integer.parseInt(text.getText()) >= one && Integer.parseInt(text.getText()) <= two) {
                    o.setText("ok");
                    return true;
                } else {
                    throw new Exception();
                }
            } catch (Exception exception) {
                o.setText("от "+one+" до "+two);
                return false;
            }
        }

        public boolean CheckF(JTextField text, JTextField text2, JLabel o, int one, int two){
            try {
                if (Integer.parseInt(text.getText()) >= one
                        && Integer.parseInt(text.getText()) <= two
                        && Integer.parseInt(text.getText()) <= Integer.parseInt(text2.getText()+2)) {
                    o.setText("ok");
                    return true;
                } else {
                    throw new Exception();
                }
            } catch (Exception exception) {
                o.setText("от "+one+" до "+two);
                return false;
            }
        }
}
