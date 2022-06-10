package ColorBox.Frontend.BlockPanel;

import ColorBox.Frontend.ControlValues.*;
import ColorBox.Frontend.Play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PaneTwoCap extends Pane {
    public PaneTwoCap() {
        JLabel labF = new JLabel("<html><b>Внутренний борт F:<b>"); // высота части внутри
        labF.setBounds(29, 163, 200, 54);
        add(labF);
        JTextField inputF = new JTextField("", 20);
        inputF.setBounds(25, 201, 100, 30);
        add(inputF);
        JLabel textF = new JLabel("\u21e0");
        textF.setBounds(125, 201, 100, 30);
        add(textF);

        JLabel labG = new JLabel("<html><b>Борт низ G:<b>"); // внешний нижний борт, высота
        labG.setBounds(29, 214, 200, 54);
        add(labG);
        JTextField inputG = new JTextField("", 20);
        inputG.setBounds(25, 252, 100, 30);
        add(inputG);
        JLabel textG = new JLabel("\u21e0");
        textG.setBounds(125, 252, 100, 30);
        add(textG);

        JLabel labH = new JLabel("<html><b>Ширина боковой линии H:<b>"); // требуемая ширина полосы между крышками
        labH.setBounds(29, 265, 200, 54);
        add(labH);
        JTextField inputH = new JTextField("", 20);
        inputH.setBounds(25, 303, 100, 30);
        add(inputH);
        JLabel textH = new JLabel("\u21e0");
        textH.setBounds(125, 303, 100, 30);
        add(textH);

        JTextArea output = new JTextArea(5, 20);
        output.setEditable(false);

        gas.getB1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean cX = CheckXYZGNumber.check(gas.getInputX(), gas.getTextX(), 30, 990);
                boolean cY = CheckXYZGNumber.check(gas.getInputY(), gas.getTextY(), 30, 690);
                boolean cZ = CheckXYZGNumber.check(gas.getInputZ(), gas.getTextZ(), 15, 350);

                boolean cF = CheckFG.check(inputF, gas.getInputZ(), textF, 0, 350);
                boolean cG = CheckFG.check(inputG, inputF, textG, 0, 350);
                boolean cH = CheckH.check(inputH, gas.getInputZ(), inputG, textH, 0, 350);

                boolean cNumber = CheckXYZGNumber.check(gas.getInputNumber(), gas.getTextNumber(), 5, 5000);
                int now = SelectedInside.check((String) gas.getjComboBoxInside().getSelectedItem());
                int plasticSelected = SelectedOutside.check((String) gas.getjComboBoxPlastic().getSelectedItem());
                if (cX && cY && cZ && cF && cG && cH && cNumber) {
                    String timeAndData =
                            LocalDate.now() + " "
                                    + LocalTime.now().getHour() + ":"
                                    + LocalTime.now().getMinute();
                    Play.report = timeAndData;;
                    Play.list = new ArrayList<>();
                    new Play().twoCap(
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
                    output.setText(Play.report);
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
