package ColorBox.Frontend;

import ColorBox.Backend.Box.BoxCap;
import ColorBox.Backend.Box.BoxMagic;
import ColorBox.Backend.Box.BoxTwoCap;
import ColorBox.Backend.Box.BoxTwoCapLite;
import ColorBox.Backend.DevelopCartoon.*;

import java.util.ArrayList;

public class Play {
    public static String report = "";
    public static ArrayList<String> list = new ArrayList<>();

    public void cap(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxCap boxOne = new BoxCap(x, y, z, f);
        DevelopCap cap = new DevelopCap();
        cap.developCap(boxOne, number, now, plasticSelected);

        for (String str : list) {
            report = report + System.lineSeparator() + str;
        }
    }

    public void magicG(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxMagic box = new BoxMagic(x, y, z, f);
        DevelopMagicG magicG = new DevelopMagicG();
        magicG.developMagicG(box, number, now, plasticSelected);

        for (String str : list) {
            report = report + System.lineSeparator() + str;
        }
    }

    public void magicV(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxMagic box = new BoxMagic(x, y, z, f);
        DevelopMagicV magicV = new DevelopMagicV();
        magicV.developMagicV(box, number, now, plasticSelected);

        for (String str : list) {
            report = report + System.lineSeparator() + str;
        }
    }

    public void twoCapLite(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxTwoCapLite boxTwoCapLite = new BoxTwoCapLite(x, y, z, f);
        DevelopTwoCapLite twoCapLite = new DevelopTwoCapLite();
        twoCapLite.developTwoCap(boxTwoCapLite, number, now, plasticSelected);

        for (String str : list) {
            report = report + System.lineSeparator() + str;
        }
    }

    public void twoCap(int x, int y, int z, int f, int g, int h, int number, int now, int plasticSelected) {
        BoxTwoCap boxTwoCap = new BoxTwoCap(x, y, z, f, g, h);
        DevelopTwoCap twoCap = new DevelopTwoCap();
        twoCap.developTwoCap(boxTwoCap, number, now, plasticSelected);

        for (String str : list) {
            report = report + System.lineSeparator() + str;
        }
    }
}
