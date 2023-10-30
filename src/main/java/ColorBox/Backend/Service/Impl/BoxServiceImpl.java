package ColorBox.Backend.Service.Impl;

import ColorBox.Backend.Entity.Box.BoxCap;
import ColorBox.Backend.Entity.Box.BoxMagic;
import ColorBox.Backend.Entity.Box.BoxTwoCap;
import ColorBox.Backend.Entity.Box.BoxTwoCapLite;
import ColorBox.Backend.Service.BoxService;
import ColorBox.Backend.Service.CheckService.ControlValues.*;
import ColorBox.Backend.Service.DevelopCartoon.*;

/**
 * Класс, реализающий "распределительные" методы под каждый тип упаковки
 *
 * cap - для упаковки "Крышка-дно"
 * magicG - для упаковки "Шкатулка" с горизонтальным положением
 * magicV -  для упаковки "Шкатулка" с вертикальным положением
 * twoCapLite - для упаковки "Двойное дно" с симметричными бортами
 * twoCap - для упаковки "Двойное дно" с разными бортами
 */
public class BoxServiceImpl implements BoxService {

    // Распределительный метод
    @Override
    public String update(String[] arr) {
        switch (arr[0]) {
            case "Крышка-дно":
                return cap(arr);
            case "Шкатулка гор":
                return magicG(arr);
            case "Шкатулка вер":
                return magicV(arr);
            case "Двойное дно":
                return twoCapLite(arr);
            case "Двойное дно (разный борт)":
                return twoCap(arr);
            default:
                return "ERROR";
        }
    }

    private String cap(String[] arr) {
        String result = "";
        String cX = CheckXYZGNumber.check(arr[1], 30, 990);
        String cY = CheckXYZGNumber.check(arr[2], 30, 690);
        String cZ = CheckXYZGNumber.check(arr[3], 15, 450);
        String cF = CheckFG.check(arr[4], arr[3], 15, 450);
        String cNumber = CheckXYZGNumber.check(arr[5], 5, 5000);
        String[] back = new String[]{cX, cY, cZ, cF, cNumber};

        for (String s : back) {
            result += s + "&";
        }

        result += arr[arr.length - 1] + "\n" + "\n";

        if (cX.equals("\u2714") && cY.equals("\u2714") && cZ.equals("\u2714")
                && cF.equals("\u2714") && cNumber.equals("\u2714")) {
            BoxCap boxOne = new BoxCap(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                    Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
            DevelopCap cap = new DevelopCap();
            result += cap.developCap(boxOne, Integer.parseInt(arr[5]),
                    SelectedInside.check(arr[6]), SelectedOutside.check(arr[7]));
        } else {
            result += "Ошибка ввода данных!";
        }
        return result;
    }

    private String magicG(String[] arr) {
        String result = "";
        String cX = CheckXYZGNumber.check(arr[1], 30, 980);
        String cY = CheckXYZGNumber.check(arr[2], 30, 680);
        String cZ = CheckXYZGNumber.check(arr[3], 30, 450);
        String cF = CheckFG.check(arr[4], arr[3], 15, 450);
        String cNumber = CheckXYZGNumber.check(arr[5], 5, 5000);
        String[] back = new String[]{cX, cY, cZ, cF, cNumber};

        for (String s : back) {
            result += s + "&";
        }

        result += arr[arr.length - 1] + "\n" + "\n";

        if (cX.equals("\u2714") && cY.equals("\u2714") && cZ.equals("\u2714")
                && cF.equals("\u2714") && cNumber.equals("\u2714")) {
            BoxMagic box = new BoxMagic(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                    Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
            DevelopMagicG magicG = new DevelopMagicG();
            result += magicG.developMagicG(box, Integer.parseInt(arr[5]),
                    SelectedInside.check(arr[6]), SelectedOutside.check(arr[7]));
        } else {
            result += "Ошибка ввода данных!";
        }
        return result;
    }

    private String magicV(String[] arr) {
        String result = "";
        String cX = CheckXYZGNumber.check(arr[1], 30, 980);
        String cY = CheckXYZGNumber.check(arr[2], 30, 680);
        String cZ = CheckXYZGNumber.check(arr[3], 30, 450);
        String cF = CheckFG.check(arr[4], arr[3], 15, 450);
        String cNumber = CheckXYZGNumber.check(arr[5], 5, 5000);
        String[] back = new String[]{cX, cY, cZ, cF, cNumber};

        for (String s : back) {
            result += s + "&";
        }

        result += arr[arr.length - 1] + "\n" + "\n";

        if (cX.equals("\u2714") && cY.equals("\u2714") && cZ.equals("\u2714")
                && cF.equals("\u2714") && cNumber.equals("\u2714")) {
            BoxMagic box = new BoxMagic(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                    Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
            DevelopMagicV magicV = new DevelopMagicV();
            result += magicV.developMagicV(box, Integer.parseInt(arr[5]),
                    SelectedInside.check(arr[6]), SelectedOutside.check(arr[7]));
        } else {
            result += "Ошибка ввода данных!";
        }
        return result;
    }

    private String twoCapLite(String[] arr) {
        String result = "";
        String cX = CheckXYZGNumber.check(arr[1], 30, 990);
        String cY = CheckXYZGNumber.check(arr[2], 30, 690);
        String cZ = CheckXYZGNumber.check(arr[3], 15, 350);
        String cF = CheckFG.check(arr[4], arr[3], 0, 350);
        String cNumber = CheckXYZGNumber.check(arr[5], 5, 5000);
        String[] back = new String[]{cX, cY, cZ, cF, cNumber};

        for (String s : back) {
            result += s + "&";
        }

        result += arr[arr.length - 1] + "\n" + "\n";

        if (cX.equals("\u2714") && cY.equals("\u2714") && cZ.equals("\u2714")
                && cF.equals("\u2714") && cNumber.equals("\u2714")) {
            BoxTwoCapLite boxTwoCapLite = new BoxTwoCapLite(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                    Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
            DevelopTwoCapLite twoCapLite = new DevelopTwoCapLite();
            result += twoCapLite.developTwoCap(boxTwoCapLite, Integer.parseInt(arr[5]),
                    SelectedInside.check(arr[6]), SelectedOutside.check(arr[7]));
        } else {
            result += "Ошибка ввода данных!";
        }
        return result;
    }

    private String twoCap(String[] arr) {
        String result = "";
        String cX = CheckXYZGNumber.check(arr[1], 30, 990);
        String cY = CheckXYZGNumber.check(arr[2], 30, 690);
        String cZ = CheckXYZGNumber.check(arr[3], 15, 350);
        String cF = CheckFG.check(arr[4], arr[3], 0, 350);
        String cG = CheckFG.check(arr[5], arr[4], 0, 350);
        String cH = CheckH.check(arr[6], arr[3], arr[5], 0, 350);
        String cNumber = CheckXYZGNumber.check(arr[5], 5, 5000);
        String[] back = new String[]{cX, cY, cZ, cF, cG, cH, cNumber};

        for (String s : back) {
            result += s + "&";
        }

        result += arr[arr.length - 1] + "\n" + "\n";

        if (cX.equals("\u2714") && cY.equals("\u2714") && cZ.equals("\u2714")
                && cF.equals("\u2714") && cNumber.equals("\u2714")
                && cG.equals("\u2714") && cH.equals("\u2714")) {
            BoxTwoCap boxTwoCap = new BoxTwoCap(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                    Integer.parseInt(arr[3]), Integer.parseInt(arr[4]),
                    Integer.parseInt(arr[5]), Integer.parseInt(arr[6]));
            DevelopTwoCap twoCap = new DevelopTwoCap();
            result += twoCap.developTwoCap(boxTwoCap, Integer.parseInt(arr[5]),
                    SelectedInside.check(arr[6]), SelectedOutside.check(arr[7]));
        } else {
            result += "Ошибка ввода данных!";
        }
        return result;
    }
}
