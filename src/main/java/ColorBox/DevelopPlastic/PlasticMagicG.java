package ColorBox.DevelopPlastic;

import ColorBox.Box.BoxMagic;
import ColorBox.Part.Film;
import ColorBox.Process.That;

public class PlasticMagicG extends PlasticCap {

    public String Roll(BoxMagic box, int number, int plasticSelected) {
        Film filmDown = new Film(box.getX() + 40 + (box.getZ() * 2),
                box.getY() + 40 + (box.getZ() * 2));
        Film filmUp = new Film(box.getX() + 40,
                ((box.getY() + 7) * 2) + (box.getF()) + (box.getZ() + 6) + 30);
        Film filmBack = new Film(box.getX(),
                box.getF() + 6 + box.getY() + 7 + 40);

        That.list.add("Оклейка снаружи:");

        switch (plasticSelected) {
            case -1:
                That.list.add("материал \"Oracal\"\n");
                Oracal(filmDown, filmUp, filmBack, number);
                break;
            case 0:
                That.list.add("материал \"DLC 1.36 м.\"\n");
                Dlc(filmDown, filmUp, filmBack, number);
                break;
            case 1:
                That.list.add("материал \"DLC 1.5 м.\"\n");
                DlcPlus(filmDown, filmUp, filmBack, number);
                break;
        }

        return "" + System.lineSeparator() + "________________________________";
    }

    private void DlcPlus(Film filmDown, Film filmUp, Film filmBack, int number) {
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

        That.list.add("На часть " + filmBack + " получится:");
        That.list.add("- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultThree = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        That.list.add("Рекомендуется - 1,5х"
                + resultOne + " м. пленки" + System.lineSeparator() + ""
        );
    }

    private void Dlc(Film filmDown, Film filmUp, Film filmBack, int number) {
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

        That.list.add("На часть " + filmBack + " получится:");
        That.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultThree = String.format("%.2f", (rollOne / 1000));
        That.list.add("Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );
    }

    private void Oracal(Film filmDown, Film filmUp, Film filmBack, int number) {
        Plastic(filmDown, number);    //дно
        Plastic(filmUp, number);      // крышка
        Plastic(filmBack, number);    // вклейка внутри

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);
    }
    @Override
    protected void Plastic(Film film, int number) {
        super.Plastic(film, number);
    }
}