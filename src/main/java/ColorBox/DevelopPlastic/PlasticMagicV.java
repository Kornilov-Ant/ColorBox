package ColorBox.DevelopPlastic;

import ColorBox.Box.BoxMagic;
import ColorBox.Part.Film;
import ColorBox.Process.That;

public class PlasticMagicV extends PlasticCap {

    public String Roll(BoxMagic box, int number) {
        Film filmDown = new Film(box.getX() + 40 + (box.getZ() * 2),
                box.getY() + 40 + (box.getZ() * 2));
        Film filmUp = new Film(box.getY() + 40,
                ((box.getX() + 7) * 2) + (box.getF()) + (box.getZ() + 6) + 30);
        Film filmBack = new Film(box.getY(),
                box.getF() + 6 + box.getX() + 7 + 40);

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
            rollOne = aD * filmDown.x;
        } else {
            bU = number / Math.floor(oracalSmall.getX() / filmDown.x);
            rollOne = bU * filmDown.y;
        }

        aD = Math.floor(oracalBig.getZ() / filmDown.x);
        aU = Math.floor(oracalBig.getX() / filmDown.y); // CONST

        bD = Math.floor(oracalBig.getZ() / filmDown.y);
        bU = Math.floor(oracalBig.getX() / filmDown.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp >= rollDown) {
            aD = number / Math.floor(oracalBig.getX() / filmDown.y);
            rollTwo = aD * filmDown.x;
        } else {
            bU = number / Math.floor(oracalBig.getX() / filmDown.x);
            rollTwo = bU * filmDown.y;
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
}
