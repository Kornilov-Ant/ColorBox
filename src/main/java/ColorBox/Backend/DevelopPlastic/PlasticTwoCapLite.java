package ColorBox.Backend.DevelopPlastic;

import ColorBox.Backend.Box.BoxTwoCapLite;
import ColorBox.Backend.Part.Film;
import ColorBox.Frontend.Play;

public class PlasticTwoCapLite extends PlasticTwoCap {

    public String roll(BoxTwoCapLite box, int number, int plasticSelected) {
        Film filmMidle = new Film(
                box.getX() + 38 + ((box.getZ() + 2) * 2),
                box.getY() + 38 + ((box.getZ() + 2) * 2)
        );
        Film filmUp = new Film(
                (box.getX() + 5) + 38 + ((box.getZ() - box.getG()) * 2),
                (box.getY() + 5) + 38 + ((box.getZ() - box.getG()) * 2)
        );
        Film filmDown = filmUp;

        Play.list.add("Оклейка снаружи:");

        switch (plasticSelected) {
            case -1:
                Play.list.add("материал \"DLC 1.5 м.\"\n");
                oracal(filmDown, filmUp, filmMidle, number);
                break;
            case 0:
                Play.list.add("материал \"DLC 1.36 м.\"\n");
                dlc(filmDown, filmUp, filmMidle, number);
                break;
            case 1:
                Play.list.add("материал \"DLC 1.5 м.\"\n");
                dlcPlus(filmDown, filmUp, filmMidle, number);
                break;
        }

        return "" + System.lineSeparator() + "________________________________";
    }

    protected void dlcPlus(Film filmDown, Film filmUp, Film filmMidle, int number) {
        super.dlcPlus(filmDown, filmUp, filmMidle, number);
    }

    protected void dlc(Film filmDown, Film filmUp, Film filmMidle, int number) {
        super.dlc(filmDown, filmUp, filmMidle, number);
    }

    private void oracal(Film filmDown, Film filmUp, Film filmMidle, int number) {
        plastic(filmDown, number);
        plastic(filmUp, number);
        plastic(filmMidle, number);

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);
    }

    @Override
    protected void plastic(Film film, int number) {
        super.plastic(film, number);
    }
}
