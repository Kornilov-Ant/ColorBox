package ColorBox.DevelopPlastic;

import ColorBox.Box.BoxMagic;
import ColorBox.Part.Film;
import ColorBox.Process.That;

public class PlasticMagicG extends PlasticCap {

    public String Roll(BoxMagic box, int number) {
        Film filmDown = new Film(box.getX() + 40 + (box.getZ() * 2),
                box.getY() + 40 + (box.getZ() * 2));
        Film filmUp = new Film(box.getX() + 40,
                ((box.getY() + 7) * 2) + (box.getZ() + 2) + (box.getZ() + 6) + 30);
        Film filmBack = new Film(box.getX(),
                box.getZ() + 6 + box.getY() + 7 + 40);

        That.list.add("Оклейка снаружи:");

        Plastic(filmDown, number);    //дно
        Plastic(filmUp, number);          // крышка
        Plastic(filmBack, number);      // вклейка внутри

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);

        return "" + System.lineSeparator() + "________________________________";
    }

    private void Plastic(Film filmDown, int number) {
        aD = Math.floor(oracalSmall.getZ() / filmDown.x);
        aU = Math.floor(oracalSmall.getX() / filmDown.y); // CONST

        bD = Math.floor(oracalSmall.getZ() / filmDown.y);
        bU = Math.floor(oracalSmall.getX() / filmDown.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(oracalSmall.getX() / filmDown.y);
            rollOne = oracalSmall.getX() + (aD * filmDown.x);
        } else {
            bU = number / Math.floor(oracalSmall.getX() / filmDown.x);
            rollOne = oracalSmall.getX() + (bU * filmDown.y);
        }

        aD = Math.floor(oracalBig.getZ() / filmDown.x);
        aU = Math.floor(oracalBig.getX() / filmDown.y); // CONST

        bD = Math.floor(oracalBig.getZ() / filmDown.y);
        bU = Math.floor(oracalBig.getX() / filmDown.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(oracalBig.getX() / filmDown.y);
            rollTwo = oracalBig.getX() + (aD * filmDown.x);
        } else {
            bU = number / Math.floor(oracalBig.getX() / filmDown.x);
            rollTwo = oracalBig.getX() + (bU * filmDown.y);
        }

        Double m22 = rollTwo * big;
        Double m21 = rollOne * small;

        That.list.add("На часть " + filmDown + " получится:");
        That.list.add("- рулон 1 м. шириной -> " + String.format("%.0f", m21) + " м2");
        That.list.add("- рулон 1,26 м. шириной -> " + String.format("%.0f", m22) + " м2");

        if (m21 <= m22) {
            String result = String.format("%.2f", (rollOne / 1000));
            That.list.add("Рекомендуется на часть " + filmDown + " - 1х"
                    + result + " м. пленки");
        } else {
            String result = String.format("%.2f", (rollTwo / 1000));
            That.list.add("Рекомендуется на часть " + filmDown + " - 1,26х"
                    + result + " м. пленки");
        }
    }
/*
    private void bigPlastic(Film filmUp, int number){
        aD = Math.floor(oracalSmall.getZ() / filmUp.x);
        aU = Math.floor(oracalSmall.getX() / filmUp.y); // CONST

        bD = Math.floor(oracalSmall.getZ() / filmUp.y);
        bU = Math.floor(oracalSmall.getX() / filmUp.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp>=rollDown){
            aD = number / Math.floor(oracalSmall.getX() / filmUp.y);
            rollOne = aD * filmUp.x;
        } else {
            bU = number / Math.floor(oracalSmall.getX() / filmUp.x);
            rollOne = bU * filmUp.y;
        }

        aD = Math.floor(oracalBig.getZ() / filmUp.x);
        aU = Math.floor(oracalBig.getX() / filmUp.y); // CONST

        bD = Math.floor(oracalBig.getZ() / filmUp.y);
        bU = Math.floor(oracalBig.getX() / filmUp.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp>=rollDown){
            aD = number / Math.floor(oracalBig.getX() / filmUp.y);
            rollTwo = aD * filmUp.x;
        } else {
            bU = number / Math.floor(oracalBig.getX() / filmUp.x);
            rollTwo = bU * filmUp.y;
        }

        Double m22 = rollTwo*big;
        Double m21 = rollOne*small;

        That.list.add("На часть " + filmUp + " получится:");
        That.list.add("- рулон 1 м. шириной -> " + String.format("%.0f", m21) + " м2");
        That.list.add("- рулон 1,26 м. шириной -> " + String.format("%.0f", m22) + " м2");

        if (m21<=m22) {
            String result = String.format("%.2f", (rollOne / 1000));
            That.list.add("Рекомендуется на часть " + filmUp + " - 1х"
                    + result + " м. пленки");
        } else {
            String result = String.format("%.2f", (rollTwo / 1000));
            That.list.add("Рекомендуется на часть " + filmUp + " - 1,26х"
                    + result + " м. пленки");
        }
    }

    private void backPlastic(Film filmBack, int number){
        aD = Math.floor(oracalSmall.getZ() / filmBack.x);
        aU = Math.floor(oracalSmall.getX() / filmBack.y); // CONST

        bD = Math.floor(oracalSmall.getZ() / filmBack.y);
        bU = Math.floor(oracalSmall.getX() / filmBack.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp>=rollDown){
            aD = number / Math.floor(oracalSmall.getX() / filmBack.y);
            rollOne = aD * filmBack.x;
        } else {
            bU = number / Math.floor(oracalSmall.getX() / filmBack.x);
            rollOne = bU * filmBack.y;
        }

        aD = Math.floor(oracalBig.getZ() / filmBack.x);
        aU = Math.floor(oracalBig.getX() / filmBack.y); // CONST

        bD = Math.floor(oracalBig.getZ() / filmBack.y);
        bU = Math.floor(oracalBig.getX() / filmBack.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp>=rollDown){
            aD = number / Math.floor(oracalBig.getX() / filmBack.y);
            rollTwo = aD * filmBack.x;
        } else {
            bU = number / Math.floor(oracalBig.getX() / filmBack.x);
            rollTwo = bU * filmBack.y;
        }

        Double m22 = rollTwo*big;
        Double m21 = rollOne*small;

        That.list.add("На часть " + filmBack + " получится:");
        That.list.add("- рулон 1 м. шириной -> " + String.format("%.0f", m21) + " м2");
        That.list.add("- рулон 1,26 м. шириной -> " + String.format("%.0f", m22) + " м2");

        if (m21<=m22) {
            String result = String.format("%.2f", (rollOne / 1000));
            That.list.add("Рекомендуется на часть " + filmBack + " - 1х"
                    + result + " м. пленки");
        } else {
            String result = String.format("%.2f", (rollTwo / 1000));
            That.list.add("Рекомендуется на часть " + filmBack + " - 1,26х"
                    + result + " м. пленки");
        }
    }
    */
}