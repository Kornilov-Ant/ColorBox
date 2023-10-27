package ColorBox.Frontend;

import ColorBox.Backend.Box.BoxCap;
import ColorBox.Backend.Box.BoxMagic;
import ColorBox.Backend.Box.BoxTwoCap;
import ColorBox.Backend.Box.BoxTwoCapLite;
import ColorBox.Backend.DevelopCartoon.*;

import java.util.ArrayList;

/**
 * Класс, реализающий "распределительные" методы под каждый тип упаковки
 *
 * cap - для упаковки "Крышка-дно"
 * magicG - для упаковки "Шкатулка" с горизонтальным положением
 * magicV -  для упаковки "Шкатулка" с вертикальным положением
 * twoCapLite - для упаковки "Двойное дно" с симметричными бортами
 * twoCap - для упаковки "Двойное дно" с разными бортами
 */
public class Play {
    // Глобальная переменная хранящая в себе конечный результат выполнения работы метода
    public static String report = "";

    // Переменная хранящая в себе поэтапный результат работы методов
    public static ArrayList<String> list = new ArrayList<>();

    /*
    В каждом методе создается объект "Box.." с входными параметрами
    и передается в "Develop.." с параметрами тиража и покрытий

    В конце метода перебирается коллекция с поэтапными результатами выполнения
    и соединяется в единую строку с разделителями
     */
    public void cap(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxCap boxOne = new BoxCap(x, y, z, f);
        new DevelopCap().developCap(boxOne, number, now, plasticSelected);

        for (String str : list) {
            report = report + System.lineSeparator() + str;
        }
    }

    public void magicG(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxMagic box = new BoxMagic(x, y, z, f);
        new DevelopMagicG().developMagicG(box, number, now, plasticSelected);

        for (String str : list) {
            report = report + System.lineSeparator() + str;
        }
    }

    public void magicV(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxMagic box = new BoxMagic(x, y, z, f);
        new DevelopMagicV().developMagicV(box, number, now, plasticSelected);

        for (String str : list) {
            report = report + System.lineSeparator() + str;
        }
    }

    public void twoCapLite(int x, int y, int z, int f, int number, int now, int plasticSelected) {
        BoxTwoCapLite boxTwoCapLite = new BoxTwoCapLite(x, y, z, f);
        new DevelopTwoCapLite().developTwoCap(boxTwoCapLite, number, now, plasticSelected);

        for (String str : list) {
            report = report + System.lineSeparator() + str;
        }
    }

    public void twoCap(int x, int y, int z, int f, int g, int h, int number, int now, int plasticSelected) {
        BoxTwoCap boxTwoCap = new BoxTwoCap(x, y, z, f, g, h);
        new DevelopTwoCap().developTwoCap(boxTwoCap, number, now, plasticSelected);

        for (String str : list) {
            report = report + System.lineSeparator() + str;
        }
    }
}
