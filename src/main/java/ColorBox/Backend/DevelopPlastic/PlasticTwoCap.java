package ColorBox.Backend.DevelopPlastic;

import ColorBox.Backend.Box.BoxTwoCap;
import ColorBox.Backend.CreateService.CreatePlastic;
import ColorBox.Backend.Part.Film;
import ColorBox.Frontend.Play;

public class PlasticTwoCap extends PlasticCap {

    public String roll(BoxTwoCap box, int number, int plasticSelected, int b) {
        Film filmMidle = new Film(
                box.getX() + 38 + ((box.getF() + 2) * 2),
                box.getY() + 38 + ((box.getF() + 2) * 2)
        );
        Film filmDown = new Film(
                (box.getX() + 5) + 38 + (box.getG() * 2),
                (box.getY() + 5) + 38 + (box.getG() * 2)
        );
        Film filmUp = new Film(
                (box.getX() + 5) + 38 + (b * 2),
                (box.getY() + 5) + 38 + (b * 2)
        );

        Play.list.add("Оклейка снаружи:");

        switch (plasticSelected) {
            case -1:
                Play.list.add("материал \"Oracal\"\n");
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
        rollOne = (double) (new CreatePlastic().create(filmDown, number, dlcP)).get(1);

        Play.list.add("На часть " + filmDown + " получится:");
        Play.list.add("- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultOne = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        Play.list.add("Рекомендуется - 1,5х"
                + resultOne + " м. пленки" + System.lineSeparator() + ""
        );

        rollOne = (double) (new CreatePlastic().create(filmUp, number, dlcP)).get(1);

        Play.list.add("На часть " + filmUp + " получится:");
        Play.list.add("- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultTwo = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        Play.list.add("Рекомендуется - 1,5х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );

        rollOne = (double) (new CreatePlastic().create(filmMidle, number, dlcP)).get(1);

        Play.list.add("На часть " + filmMidle + " получится:");
        Play.list.add("- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultThree = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        Play.list.add("Рекомендуется - 1,5х"
                + resultOne + " м. пленки" + System.lineSeparator() + ""
        );
    }

    protected void dlc(Film filmDown, Film filmUp, Film filmMidle, int number) {
        rollOne = (double) (new CreatePlastic().create(filmDown, number, dlc)).get(1);

        Play.list.add("На часть " + filmDown + " получится:");
        Play.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultOne = String.format("%.2f", (rollOne / 1000));
        //ниже идет добавление текста!!!
        Play.list.add("Рекомендуется - 1,37х"
                + resultOne + " м. пленки" + System.lineSeparator() + ""
        );

        rollOne = (double) (new CreatePlastic().create(filmUp, number, dlc)).get(1);

        Play.list.add("На часть " + filmUp + " получится:");
        Play.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultTwo = String.format("%.2f", (rollOne / 1000));
        Play.list.add("Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );

        rollOne = (double) (new CreatePlastic().create(filmMidle, number, dlc)).get(1);

        Play.list.add("На часть " + filmMidle + " получится:");
        Play.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultThree = String.format("%.2f", (rollOne / 1000));
        Play.list.add("Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );
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
