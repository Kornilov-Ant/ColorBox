package ColorBox.Backend.DevelopPlastic;

import ColorBox.Backend.Box.BoxCap;
import ColorBox.Backend.CreateService.CreatePlastic;
import ColorBox.Backend.Part.Film;
import ColorBox.Backend.Plastic.*;
import ColorBox.Frontend.Play;

public class PlasticCap {

    protected Plastic oracalBig = new Plastic(1260);
    protected Plastic oracalSmall = new Plastic(1000);
    protected Plastic dlc = new Plastic(1370);
    protected Plastic dlcP = new Plastic(1500);
    protected double rollOne, rollTwo;
    protected double small = 1.00;
    protected double big = 1.26;

    public String roll(BoxCap box, int number, int plasticSelected) {
        Film filmDown = new Film(box.getX() + 38 + (box.getZ() * 2),
                box.getY() + 38 + (box.getZ() * 2));
        Film filmUp = new Film(box.getX() + 43 + (box.getF() * 2),
                box.getY() + 43 + (box.getF() * 2));

        Play.list.add("Оклейка снаружи:");

        switch (plasticSelected) {
            case -1:
                Play.list.add("материал \"Oracal\"\n");
                oracal(filmDown, filmUp, number);
                break;
            case 0:
                Play.list.add("материал \"DLC 1.36 м.\"\n");
                dlc(filmDown, filmUp, number);
                break;
            case 1:
                Play.list.add("материал \"DLC 1.5 м.\"\n");
                dlcPlus(filmDown, filmUp, number);
                break;
        }

        return "" + System.lineSeparator() + "________________________________";
    }

    private void dlcPlus(Film filmDown, Film filmUp, int number) {
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
    }

    private void dlc(Film filmDown, Film filmUp, int number) {
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

        rollOne = (double) (new CreatePlastic().create(filmUp, number, dlcP)).get(1);

        Play.list.add("На часть " + filmUp + " получится:");
        Play.list.add("- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2"
        );

        String resultTwo = String.format("%.2f", (rollOne / 1000));
        Play.list.add("Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + ""
        );
    }

    private void oracal(Film filmDown, Film filmUp, int number) {
        plastic(filmDown, number);    //дно
        plastic(filmUp, number);          // крышка

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);
    }

    protected void plastic(Film film, int number) {
        rollOne = (double) (new CreatePlastic().create(film, number, oracalSmall)).get(1);

        rollTwo = (double) (new CreatePlastic().create(film, number, oracalBig)).get(1);

        Double m22 = rollTwo * big;
        Double m21 = rollOne * small;

        Play.list.add("На часть " + film + " получится:");

        Play.list.add("- рулон 1 м. шириной -> "
                + String.format("%.0f", m21) + " м2"
        );

        Play.list.add("- рулон 1,26 м. шириной -> "
                + String.format("%.0f", m22) + " м2"
        );


        if (m21 <= m22) {
            String result = String.format("%.2f", (rollOne / 1000));
            //ниже идет добавление текста!!!
            Play.list.add("Рекомендуется на часть " + film +
                    " - 1х" + result + " м. пленки"
                    + System.lineSeparator() + ""
            );
        } else {
            String result = String.format("%.2f", (rollTwo / 1000));
            //ниже идет добавление текста!!!
            Play.list.add("Рекомендуется на часть " + film +
                    " - 1,26х" + result + " м. пленки"
            );
        }
    }
}
