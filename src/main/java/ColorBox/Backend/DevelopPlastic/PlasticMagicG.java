package ColorBox.Backend.DevelopPlastic;

import ColorBox.Backend.Box.BoxMagic;
import ColorBox.Backend.CreateService.CreatePlastic;
import ColorBox.Backend.Part.Film;
import ColorBox.Frontend.Play;

public class PlasticMagicG extends PlasticCap {

    public String roll(BoxMagic box, int number, int plasticSelected) {
        Film filmDown = new Film(box.getX() + 40 + (box.getZ() * 2),
                box.getY() + 40 + (box.getZ() * 2));
        Film filmUp = new Film(box.getX() + 40,
                ((box.getY() + 7) * 2) + (box.getF()) + (box.getZ() + 6) + 30);
        Film filmBack = new Film(box.getX(),
                box.getF() + 6 + box.getY() + 7 + 40);

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

        rollOne = (double) (new CreatePlastic().create(filmBack, number, dlcP)).get(1);

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

    protected void dlc(Film filmDown, Film filmUp, Film filmBack, int number) {

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

        rollOne = (double) (new CreatePlastic().create(filmBack, number, dlc)).get(1);

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