package ColorBox.DevelopPlastic;

import ColorBox.Box.BoxTwoCapLite;
import ColorBox.Part.Film;
import ColorBox.Process.That;

public class PlasticTwoCapLite extends PlasticCap {

    public String Roll(BoxTwoCapLite box, int number) {
        Film filmMidle = new Film(
                box.getX() + 38 + (box.getZ() * 2),
                box.getY() + 38 + (box.getZ() * 2)
        );
        Film filmDownAndUp = new Film(
                (box.getX() + 5) + 38 + (box.getZ() - box.getG()),
                (box.getY() + 5) + 38 + (box.getZ() - box.getG())
        );

        That.list.add("Оклейка снаружи:");

        Plastic(filmMidle, number);    //дно
        Plastic(filmDownAndUp, number);          // крышка 1
        Plastic(filmDownAndUp, number);          // крышка 2

        oracalBig.setY(Math.round(oracalBig.getY()*100)/100D);
        oracalSmall.setY(Math.round(oracalSmall.getY()*100)/100D);

        return "" + System.lineSeparator() + "________________________________";
    }
    private void Plastic(Film film, int number){
        aD = Math.floor(oracalSmall.getZ() / film.x);
        aU = Math.floor(oracalSmall.getX() / film.y); // CONST

        bD = Math.floor(oracalSmall.getZ() / film.y);
        bU = Math.floor(oracalSmall.getX() / film.x); // CONST

        rollUp = aD * aU;
        rollDown = bD * bU;

        if (rollUp>=rollDown){
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

        if (rollUp>=rollDown){
            aD = number / Math.floor(oracalBig.getX() / film.y);
            rollTwo = aD * film.x;
        } else {
            bU = number / Math.floor(oracalBig.getX() / film.x);
            rollTwo = bU * film.y;
        }

        Double m22 = rollTwo*big;
        Double m21 = rollOne*small;

        That.list.add("На часть " + film + " получится:");
        That.list.add("- рулон 1 м. шириной -> " + String.format("%.0f", m21) + " м2");
        That.list.add("- рулон 1,26 м. шириной -> " + String.format("%.0f", m22) + " м2");


        if (m21<=m22) {
            String result = String.format("%.2f", (rollOne / 1000));
            //ниже идет добавление текста!!!
            That.list.add("Рекомендуется на часть " + film + " - 1х"
                    + result + " м. пленки" + System.lineSeparator() + "");
        } else {
            String result = String.format("%.2f", (rollTwo / 1000));
            //ниже идет добавление текста!!!
            That.list.add("Рекомендуется на часть " + film + " - 1,26х"
                    + result + " м. пленки");
        }
    }
}
