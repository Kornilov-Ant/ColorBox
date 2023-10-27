package ColorBox;

import javax.swing.*;

import ColorBox.Frontend.Panel;

/**
 * Запуск приложение начинается с этого класса
 * Описание элементов и их смысл - по возможности комментируется
 */
public class Start {

    // Главная переменная, которая хранит в себе параметры окна (фрейма)
    private JFrame window;

    public Start() {
        // Присваивается новый объект фрейму
        // и задается текст для верхней плашки графического интерфейса
        window = new JFrame("ColorBox (СиБи)");

        // Задается фиксированный размер общего окна 700х670 px.
        window.setSize(700, 670);

        // действие при нажатии на "крестик" (закрыть приложение)
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Помещает в "окну" новый объект "Panel"
        window.add(new Panel());

        // Помещает фрейм в центр экрана
        window.setLocationRelativeTo(null);

        // Запрещает пользователю менять размер окна
        window.setResizable(false);

        // Сделать окно видимым
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Start();
            }
        });
    }

}
