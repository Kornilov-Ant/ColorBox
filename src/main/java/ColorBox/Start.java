package ColorBox;

import javax.swing.*;
import ColorBox.Process.*;

public class Start {

    private JFrame window;

    public Start(){
         window = new JFrame("ColorBox (Си-Би)");
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         window.setSize(700, 550);

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
