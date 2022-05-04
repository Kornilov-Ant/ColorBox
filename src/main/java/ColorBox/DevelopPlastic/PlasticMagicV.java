package ColorBox.DevelopPlastic;

import ColorBox.Box.BoxMagic;
import ColorBox.Part.Film;
import ColorBox.Process.Play;

public class PlasticMagicV extends PlasticCap {

    public String roll(BoxMagic box, int number, int plasticSelected) {
        Film filmDown = new Film(box.getX() + 40 + (box.getZ() * 2),
                box.getY() + 40 + (box.getZ() * 2));
        Film filmUp = new Film(box.getY() + 40,
                ((box.getX() + 7) * 2) + (box.getF()) + (box.getZ() + 6) + 30);
        Film filmBack = new Film(box.getY(),
                box.getF() + 6 + box.getX() + 7 + 40);

        Play.list.add("Оклейка снаружи:");

        switch (plasticSelected) {
            case -1:
                Play.list.add("материал \"Oracal\"\n");
                oracal(filmDown, filmUp, filmBack, number);
                break;
            case 0:
                Play.list.add("материал \"DLC 1.36 м.\"\n");
                dlc(filmDown, filmUp, filmBack, number);
                break;
            case 1:
                Play.list.add("материал \"DLC 1.5 м.\"\n");
                dlcPlus(filmDown, filmUp, filmBack, number);
                break;
        }

        return "" + System.lineSeparator() + "________________________________";
    }

    private void dlcPlus(Film filmDown, Film filmUp, Film filmBack, int number) {
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

        Play.list.add("На часть " + filmDown + " получится:");
        Play.list.add("- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultOne = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        Play.list.add("Рекомендуется - 1,5х"
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

        Play.list.add("На часть " + filmUp + " получится:");
        Play.list.add("- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultTwo = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        Play.list.add("Рекомендуется - 1,5х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );

        aD = Math.floor(dlcPlus.getZ() / filmBack.x);
        aU = Math.floor(dlcPlus.getX() / filmBack.y); // CONST

        bD = Math.floor(dlcPlus.getZ() / filmBack.y);
        bU = Math.floor(dlcPlus.getX() / filmBack.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(dlcPlus.getX() / filmBack.y);
            rollOne = aD * filmBack.x;
        } else {
            bU = number / Math.floor(dlcPlus.getX() / filmBack.x);
            rollOne = bU * filmBack.y;
        }

        Play.list.add("На часть " + filmBack + " получится:");
        Play.list.add("- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultThree = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        Play.list.add("Рекомендуется - 1,5х"
                + resultOne + " м. пленки" + System.lineSeparator() + ""
        );
    }

    private void dlc(Film filmDown, Film filmUp, Film filmBack, int number) {
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

        Play.list.add("На часть " + filmDown + " получится:");
        Play.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultOne = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        Play.list.add("Рекомендуется - 1,37х"
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

        Play.list.add("На часть " + filmUp + " получится:");
        Play.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultTwo = String.format("%.2f", (rollOne / 1000));
        Play.list.add("Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );

        aD = Math.floor(dlc.getZ() / filmBack.x);
        aU = Math.floor(dlc.getX() / filmBack.y); // CONST

        bD = Math.floor(dlc.getZ() / filmBack.y);
        bU = Math.floor(dlc.getX() / filmBack.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(dlc.getX() / filmBack.y);
            rollOne = aD * filmBack.x;
        } else {
            bU = number / Math.floor(dlc.getX() / filmBack.x);
            rollOne = bU * filmBack.y;
        }

        Play.list.add("На часть " + filmBack + " получится:");
        Play.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultThree = String.format("%.2f", (rollOne / 1000));
        Play.list.add("Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );
    }

    private void oracal(Film filmDown, Film filmUp, Film filmBack, int number) {
        plastic(filmDown, number);    //дно
        plastic(filmUp, number);      // крышка
        plastic(filmBack, number);    // вклейка внутри

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);
    }
    @Override
    protected void plastic(Film film, int number) {
        super.plastic(film, number);
    }
}
