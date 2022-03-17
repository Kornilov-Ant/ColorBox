package ColorBox.Process;

import ColorBox.Box.BoxCap;
import ColorBox.Box.BoxMagic;
import ColorBox.Box.BoxTwoCapLite;

import java.util.ArrayList;

public class That {
    public static String ou = "";
    public static ArrayList<String> list = new ArrayList<>();

    public void Cap(int x, int y, int z, int f, int number, boolean now) {
        BoxCap boxOne = new BoxCap(x, y, z, f);
        Play cap = new Play();
        cap.Play(boxOne, number, now);

        for (String str : list) {
            ou = ou + System.lineSeparator() + str;
        }
    }
    public void MagicG(int x, int y, int z, int number, boolean now) {
        BoxMagic box = new BoxMagic(x,y,z);
        Play cap = new Play();
        cap.Play(box, number,  0, now);

        for (String str : list) {
            ou = ou + System.lineSeparator() + str;
        }
    }
    public void MagicV(int x, int y, int z, int number, boolean now) {
        BoxMagic box = new BoxMagic(x,y,z);
        Play cap = new Play();
        cap.Play(box, number, 1, now);

        for (String str : list) {
            ou = ou + System.lineSeparator() + str;
        }
    }
    public void TwoCapLite(int x, int y, int z, int f, int number, boolean now) {
        BoxTwoCapLite boxTwoCapLite = new BoxTwoCapLite(x, y, z, f);
        Play cap = new Play();
        cap.Play(boxTwoCapLite, number, now);

        for (String str : list) {
            ou = ou + System.lineSeparator() + str;
        }
    }

}
