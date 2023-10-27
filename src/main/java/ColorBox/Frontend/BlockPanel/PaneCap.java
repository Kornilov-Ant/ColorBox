package ColorBox.Frontend.BlockPanel;

import ColorBox.Backend.CheckService.ControlValues.CheckFG;
import ColorBox.Backend.CheckService.ControlValues.CheckXYZGNumber;
import ColorBox.Backend.CheckService.ControlValues.SelectedInside;
import ColorBox.Backend.CheckService.ControlValues.SelectedOutside;
import ColorBox.Frontend.Play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *  Класс наследник Pane и расширяющий его функционал
 *
 *  Это вкладка "Крышка-Дно"
 */
public class PaneCap extends Pane {
    public PaneCap() {
        // Код ниже добавляет блок "Высота крышки" к вкладке
        JLabel labF = new JLabel("<html><b>Высота крышки F:<b>");
        labF.setBounds(29, 163, 200, 54);
        add(labF);
        JTextField inputF = new JTextField("", 20);
        inputF.setBounds(25, 201, 100, 30);
        add(inputF);
        JLabel textF = new JLabel("\u21e0");
        textF.setBounds(125, 201, 100, 30);
        add(textF);

        // Добавляется текстовое окно
        JTextArea output = new JTextArea(5, 20);
        // Опция редактирования текста в нем отключена
        output.setEditable(false);

        // Добавление слушателя на кнопку "Посчитать" и его реализация
        gas.getB1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Проверки корректности введенных данных согласно условиям
                boolean cX = CheckXYZGNumber.check(gas.getInputX(), gas.getTextX(), 30, 990);
                boolean cY = CheckXYZGNumber.check(gas.getInputY(), gas.getTextY(), 30, 690);
                boolean cZ = CheckXYZGNumber.check(gas.getInputZ(), gas.getTextZ(), 15, 450);
                boolean cF = CheckFG.check(inputF, gas.getInputZ(), textF, 15, 450);
                boolean cNumber = CheckXYZGNumber.check(gas.getInputNumber(), gas.getTextNumber(), 5, 5000);

                // Считываются числовые коды выбора материала покрытия
                int now = SelectedInside.check((String) gas.getJComboBoxInside().getSelectedItem());
                int plasticSelected = SelectedOutside.check((String) gas.getJComboBoxPlastic().getSelectedItem());

                // Далее идет блок, вполняется если все данные прошли проверку
                // иначе пользователю сообщают, что данные введены с ошибкой
                if (cX && cY && cZ && cF && cNumber) {

                    // Сохраняется текущее время и дата
                    String timeAndData =
                            LocalDate.now() + " "
                                    + LocalTime.now().getHour() + ":"
                                    + LocalTime.now().getMinute();

                    // Время и дата помещаются в глобальную переменную "report"
                    Play.report = timeAndData;
                    Play.list = new ArrayList<>();

                    // Все данные передаются в метод "cap" статического класса "Play"
                    new Play().cap(
                            Integer.parseInt(gas.getInputX().getText()),
                            Integer.parseInt(gas.getInputY().getText()),
                            Integer.parseInt(gas.getInputZ().getText()),
                            Integer.parseInt(inputF.getText()),
                            Integer.parseInt(gas.getInputNumber().getText()),
                            now,
                            plasticSelected
                    );

                    // Результат работы метода сохраненный в "report" передается в объект вывода текста
                    output.setText(Play.report);
                } else {
                    output.setText("Ошибка ввода данных!");
                }
            }
        });

        // к интерфейсу добавляется объект вывода текста
        add(output);

        // Создается и добавляется к интерфейсу возможность прокручивать полученный результат,
        // если объем выведенного текста не помещается в окне
        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setBounds(275, 25, 375, 525);
        scrollPane.setPreferredSize(new Dimension(375, 525));
        add(scrollPane);
    }
}
