package ColorBox.DevelopPlastic;

import ColorBox.Box.BoxCap;
import ColorBox.Part.Film;
import ColorBox.Plastic.*;
import ColorBox.Process.That;

public class PlasticCap {
    protected OracalBig oracalBig = new OracalBig();
    protected OracalSmall oracalSmall = new OracalSmall();
    protected Dlc dlc = new Dlc();
    protected DlcPlus dlcPlus = new DlcPlus();
    protected double rollOne, rollTwo, rollDown, rollUp, aD, aU, bD, bU;
    protected double small = 1.00;
    protected double big = 1.26;

    public String Roll(BoxCap box, int number, int plasticSelected) {
        Film filmDown = new Film(box.getX() + 38 + (box.getZ() * 2),
                box.getY() + 38 + (box.getZ() * 2));
        Film filmUp = new Film(box.getX() + 43 + (box.getF() * 2),
                box.getY() + 43 + (box.getF() * 2));

        That.list.add("Оклейка снаружи:");

        switch (plasticSelected) {
            case -1:
                Oracal(filmDown, filmUp, number);
                break;
            case 0:
                Dlc(filmDown, filmUp, number);
                break;
            case 1:
                DlcPlus(filmDown, filmUp, number);
                break;
        }

        return "" + System.lineSeparator() + "________________________________";
    }

    private void DlcPlus(Film filmDown, Film filmUp, int number) {
        aD = Math.floor(dlcPlus.getZ() / filmDown.x);
        aU = Math.floor(dlcPlus.getX() / filmDown.y); // CONST

        bD = Math.floor(dlcPlus.getZ() / filmDown.y);
        bU = Math.floor(dlcPlus.getX() / filmDown.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(dlcPlus.getX() / filmDown.y);
            rollOne = aD * filmDown.x;
        } else {
            bU = number / Math.floor(dlcPlus.getX() / filmDown.x);
            rollOne = bU * filmDown.y;
        }

        That.list.add("На часть " + filmDown + " получится:");
        That.list.add("- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultOne = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        That.list.add("Рекомендуется - 1,5х"
                + resultOne + " м. пленки" + System.lineSeparator() + ""
        );

        aD = Math.floor(dlcPlus.getZ() / filmUp.x);
        aU = Math.floor(dlcPlus.getX() / filmUp.y); // CONST

        bD = Math.floor(dlcPlus.getZ() / filmUp.y);
        bU = Math.floor(dlcPlus.getX() / filmUp.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(dlcPlus.getX() / filmUp.y);
            rollOne = aD * filmDown.x;
        } else {
            bU = number / Math.floor(dlcPlus.getX() / filmUp.x);
            rollOne = bU * filmDown.y;
        }

        That.list.add("На часть " + filmUp + " получится:");
        That.list.add("- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultTwo = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        That.list.add("Рекомендуется - 1,5х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );
    }

    private void Dlc(Film filmDown, Film filmUp, int number) {
        aD = Math.floor(dlc.getZ() / filmDown.x);
        aU = Math.floor(dlc.getX() / filmDown.y); // CONST

        bD = Math.floor(dlc.getZ() / filmDown.y);
        bU = Math.floor(dlc.getX() / filmDown.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(dlc.getX() / filmDown.y);
            rollOne = aD * filmDown.x;
        } else {
            bU = number / Math.floor(dlc.getX() / filmDown.x);
            rollOne = bU * filmDown.y;
        }

        That.list.add("На часть " + filmDown + " получится:");
        That.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultOne = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        That.list.add("Рекомендуется - 1,37х"
                + resultOne + " м. пленки" + System.lineSeparator() + ""
        );

        aD = Math.floor(dlc.getZ() / filmUp.x);
        aU = Math.floor(dlc.getX() / filmUp.y); // CONST

        bD = Math.floor(dlc.getZ() / filmUp.y);
        bU = Math.floor(dlc.getX() / filmUp.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(dlc.getX() / filmUp.y);
            rollOne = aD * filmDown.x;
        } else {
            bU = number / Math.floor(dlc.getX() / filmUp.x);
            rollOne = bU * filmDown.y;
        }

        That.list.add("На часть " + filmUp + " получится:");
        That.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultTwo = String.format("%.2f", (rollOne / 1000));
        That.list.add("Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );
    }

    private void Oracal(Film filmDown, Film filmUp, int number) {
        Plastic(filmDown, number);    //дно
        Plastic(filmUp, number);          // крышка

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);
    }

    private void Plastic(Film film, int number) {
        aD = Math.floor(oracalSmall.getZ() / film.x);
        aU = Math.floor(oracalSmall.getX() / film.y); // CONST

        bD = Math.floor(oracalSmall.getZ() / film.y);
        bU = Math.floor(oracalSmall.getX() / film.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(oracalSmall.getX() / film.y);
            rollOne = aD * film.x;
        } else {
            bU = number / Math.floor(oracalSmall.getX() / film.x);
            rollOne = bU * film.y;
        }

        aD = Math.floor(oracalBig.getZ() / film.x);
        aU = Math.floor(oracalBig.getX() / film.y); // CONST

        bD = Math.floor(oracalBig.getZ() / film.y);
        bU = Math.floor(oracalBig.getX() / film.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(oracalBig.getX() / film.y);
            rollTwo = aD * film.x;
        } else {
            bU = number / Math.floor(oracalBig.getX() / film.x);
            rollTwo = bU * film.y;
        }

        Double m22 = rollTwo * big;
        Double m21 = rollOne * small;

        That.list.add("На часть " + film + " получится:");

        That.list.add("- рулон 1 м. шириной -> "
                + String.format("%.0f", m21) + " м2"
        );

        That.list.add("- рулон 1,26 м. шириной -> "
                + String.format("%.0f", m22) + " м2"
        );


        if (m21 <= m22) {
            String result = String.format("%.2f", (rollOne / 1000));
            //ниже идет добавление текста!!!
            That.list.add("Рекомендуется на часть " + film +
                    " - 1х" + result + " м. пленки"
                    + System.lineSeparator() + ""
            );
        } else {
            String result = String.format("%.2f", (rollTwo / 1000));
            //ниже идет добавление текста!!!
            That.list.add("Рекомендуется на часть " + film +
                    " - 1,26х" + result + " м. пленки"
            );
        }
    }
}
