package ColorBox.Process;

import ColorBox.Box.BoxCap;
import ColorBox.Box.BoxMagic;
import ColorBox.Box.BoxTwoCapLite;

import java.util.ArrayList;

public class That {
    public static String ou = "";
    public static ArrayList<String> list = new ArrayList<>();

    public void Cap(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxCap boxOne = new BoxCap(x, y, z, f);
        Play cap = new Play();
        cap.Play(boxOne, number, now, plasticSelected);

        for (String str : list) {
            ou = ou + System.lineSeparator() + str;
        }
    }

    public void MagicG(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxMagic box = new BoxMagic(x, y, z, f);
        Play cap = new Play();
        cap.Play(box, number, 0, now, plasticSelected);

        for (String str : list) {
            ou = ou + System.lineSeparator() + str;
        }
    }

    public void MagicV(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxMagic box = new BoxMagic(x, y, z, f);
        Play cap = new Play();
        cap.Play(box, number, 1, now, plasticSelected);

        for (String str : list) {
            ou = ou + System.lineSeparator() + str;
        }
    }

    public void TwoCapLite(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxTwoCapLite boxTwoCapLite = new BoxTwoCapLite(x, y, z, f);
        Play cap = new Play();
        cap.Play(boxTwoCapLite, number, now, plasticSelected);

        for (String str : list) {
            ou = ou + System.lineSeparator() + str;
        }
    }

}
