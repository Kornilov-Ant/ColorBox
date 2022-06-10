package ColorBox.Backend.DevelopPlastic;

import ColorBox.Backend.Box.BoxMagic;
import ColorBox.Backend.CreateService.CreatePlastic;
import ColorBox.Backend.Part.Film;
import ColorBox.Frontend.Play;

public class PlasticMagicV extends PlasticMagicG {

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

    protected void dlcPlus(Film filmDown, Film filmUp, Film filmBack, int number) {
        super.dlcPlus(filmDown, filmUp, filmBack, number);
    }

    protected void dlc(Film filmDown, Film filmUp, Film filmBack, int number) {
        super.dlc(filmDown, filmUp, filmBack, number);
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
