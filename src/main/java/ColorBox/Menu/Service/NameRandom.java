package ColorBox.Menu.Service;

import java.util.Random;

public class NameRandom {

    private String line;

    private String letterRandom() {
        while (true) {
            int back = new Random().nextInt(122);
            if (back > 64 && back < 91 || back > 96 && back < 123) {
                if (line.length() < 4) {
                    line += (char) back;
                } else {
                    return line;
                }
            }
        }
    }

    public String nameRandom(String report) {
        if (report.contains("Крышка-дно")) {
            line = "_Simple_box_#";
        } else if (report.contains("Шкатулка горизонтальная")) {
            line = "_Magnetic_boxG_#";
        } else if (report.contains("Шкатулка вертикальная")) {
            line = "_Magnetic_boxV_#";
        } else if (report.contains("Двойное дно, выровненные борта")) {
            line = "_Two_Cap_#";
        } else if (report.contains("Двойное дно, разные борта")) {
            line = "_Two_Cap_Lite_#";
        }
        line += letterRandom();
        return line;
    }

}
