package ColorBox;

import javax.swing.*;

import ColorBox.Menu.UpMenuBar;
import ColorBox.Process.*;
import ColorBox.Process.Panel;

import java.awt.*;

public class Start {

    private JFrame window;

    public Start() {
        window = new JFrame("ColorBox (Си-Би)");
        window.setSize(700, 670);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new Panel());
        window.setLocationRelativeTo(null);
        window.setResizable(false);
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
