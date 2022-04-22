package ColorBox.DevelopPlastic;

import ColorBox.Box.BoxTwoCapLite;
import ColorBox.Part.Film;
import ColorBox.Process.That;

public class PlasticTwoCapLite extends PlasticCap {

    public String Roll(BoxTwoCapLite box, int number, int plasticSelected) {
        Film filmMidle = new Film(
                box.getX() + 38 + (box.getZ() * 2),
                box.getY() + 38 + (box.getZ() * 2)
        );
        Film filmUp = new Film(
                (box.getX() + 5) + 38 + (box.getZ() - box.getG()),
                (box.getY() + 5) + 38 + (box.getZ() - box.getG())
        );
        Film filmDown = filmUp;

        That.list.add("Оклейка снаружи:");

        switch (plasticSelected) {
            case -1:
                Oracal(filmDown, filmUp, filmMidle, number);
                break;
            case 0:
                Dlc(filmDown, filmUp, filmMidle, number);
                break;
            case 1:
                DlcPlus(filmDown, filmUp, filmMidle, number);
                break;
        }

        return "" + System.lineSeparator() + "________________________________";
    }

    private void DlcPlus(Film filmDown, Film filmUp, Film filmMidle, int number) {
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
            rollOne = aD * filmUp.x;
        } else {
            bU = number / Math.floor(dlcPlus.getX() / filmUp.x);
            rollOne = bU * filmUp.y;
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

        aD = Math.floor(dlcPlus.getZ() / filmMidle.x);
        aU = Math.floor(dlcPlus.getX() / filmMidle.y); // CONST

        bD = Math.floor(dlcPlus.getZ() / filmMidle.y);
        bU = Math.floor(dlcPlus.getX() / filmMidle.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(dlcPlus.getX() / filmMidle.y);
            rollOne = aD * filmMidle.x;
        } else {
            bU = number / Math.floor(dlcPlus.getX() / filmMidle.x);
            rollOne = bU * filmMidle.y;
        }

        That.list.add("На часть " + filmMidle + " получится:");
        That.list.add("- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultThree = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        That.list.add("Рекомендуется - 1,5х"
                + resultOne + " м. пленки" + System.lineSeparator() + ""
        );
    }

    private void Dlc(Film filmDown, Film filmUp, Film filmMidle, int number) {
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
            rollOne = aD * filmUp.x;
        } else {
            bU = number / Math.floor(dlc.getX() / filmUp.x);
            rollOne = bU * filmUp.y;
        }

        That.list.add("На часть " + filmUp + " получится:");
        That.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultTwo = String.format("%.2f", (rollOne / 1000));
        That.list.add("Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );

        aD = Math.floor(dlc.getZ() / filmMidle.x);
        aU = Math.floor(dlc.getX() / filmMidle.y); // CONST

        bD = Math.floor(dlc.getZ() / filmMidle.y);
        bU = Math.floor(dlc.getX() / filmMidle.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(dlc.getX() / filmMidle.y);
            rollOne = aD * filmMidle.x;
        } else {
            bU = number / Math.floor(dlc.getX() / filmMidle.x);
            rollOne = bU * filmMidle.y;
        }

        That.list.add("На часть " + filmMidle + " получится:");
        That.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultThree = String.format("%.2f", (rollOne / 1000));
        That.list.add("Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );
    }

    private void Oracal(Film filmDown, Film filmUp, Film filmMidle, int number) {
        Plastic(filmDown, number);
        Plastic(filmUp, number);
        Plastic(filmMidle, number);

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);
    }
    @Override
    protected void Plastic(Film film, int number) {
        super.Plastic(film, number);
    }
}
