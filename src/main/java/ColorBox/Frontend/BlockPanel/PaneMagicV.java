package ColorBox.Frontend.BlockPanel;

import ColorBox.Frontend.ControlValues.CheckFG;
import ColorBox.Frontend.ControlValues.CheckXYZGNumber;
import ColorBox.Frontend.ControlValues.SelectedInside;
import ColorBox.Frontend.ControlValues.SelectedOutside;
import ColorBox.Frontend.Play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PaneMagicV extends Pane {
    public PaneMagicV() {
        JLabel labF = new JLabel("<html><b>Высота клапана F:<b>");
        labF.setBounds(29, 163, 200, 54);
        add(labF);
        JTextField inputF = new JTextField("", 20);
        inputF.setBounds(25, 201, 100, 30);
        add(inputF);
        JLabel textF = new JLabel("\u21e0");
        textF.setBounds(125, 201, 100, 30);
        add(textF);

        JTextArea output = new JTextArea(5, 20);
        output.setEditable(false);

        gas.getB1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean cX = CheckXYZGNumber.check(gas.getInputX(), gas.getTextX(), 30, 450);
                boolean cY = CheckXYZGNumber.check(gas.getInputY(), gas.getTextY(), 30, 450);
                boolean cZ = CheckXYZGNumber.check(gas.getInputZ(), gas.getTextZ(), 30, 350);
                boolean cF = CheckFG.check(inputF, gas.getInputZ(), textF, 15, 450);
                boolean cNumber = CheckXYZGNumber.check(gas.getInputNumber(), gas.getTextNumber(), 5, 5000);
                int now = SelectedInside.check((String) gas.getjComboBoxInside().getSelectedItem());
                int plasticSelected = SelectedOutside.check((String) gas.getjComboBoxPlastic().getSelectedItem());
                if (cX && cY && cZ && cNumber) {
                    String timeAndData =
                            LocalDate.now() + " "
                                    + LocalTime.now().getHour() + ":"
                                    + LocalTime.now().getMinute();
                    Play.report = timeAndData;;
                    Play.list = new ArrayList<>();
                    new Play().magicV(
                            Integer.parseInt(gas.getInputX().getText()),
                            Integer.parseInt(gas.getInputY().getText()),
                            Integer.parseInt(gas.getInputZ().getText()),
                            Integer.parseInt(inputF.getText()),
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
