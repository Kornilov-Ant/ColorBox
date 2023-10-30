package ColorBox.Backend.Service.DevelopPlastic;

import ColorBox.Backend.Entity.Box.BoxTwoCap;
import ColorBox.Backend.Service.CreateService.CreatePlastic;
import ColorBox.Backend.Entity.Part.Film;

/**
 * Класс, реализующий тех. логику просчета материала Plastic,
 * для сборки упаковки "Двойное дно с одинаковыми бортами"
 */
public class PlasticTwoCap extends PlasticCap {

    public String roll(BoxTwoCap box, int number, int plasticSelected, int b) {
        // Задаются размеры для Plastic внутренний каркас
        Film filmMiddle = new Film(
                box.getX() + 38 + ((box.getF() + 2) * 2),
                box.getY() + 38 + ((box.getF() + 2) * 2)
        );
        // Задаются размеры для Plastic дно
        Film filmDown = new Film(
                (box.getX() + 5) + 38 + (box.getG() * 2),
                (box.getY() + 5) + 38 + (box.getG() * 2)
        );
        // Задаются размеры для Plastic крышка
        Film filmUp = new Film(
                (box.getX() + 5) + 38 + (b * 2),
                (box.getY() + 5) + 38 + (b * 2)
        );
        String result = "Оклейка снаружи:\n";

        // В зависимости от выбранного пункта пользователем
        // в блоке case вызывается метод соответствующий материалу
        switch (plasticSelected) {
            case -1:
                result += "материал \"Oracal\"\n";
                result += oracal(filmDown, filmUp, filmMiddle, number);
                break;
            case 0:
                result += "материал \"DLC 1.36 м.\"\n";
                result += dlc(filmDown, filmUp, filmMiddle, number);
                break;
            case 1:
                result += "материал \"DLC 1.5 м.\"\n";
                result += dlcPlus(filmDown, filmUp, filmMiddle, number);
                break;
        }

        result += "" + System.lineSeparator() + "________________________________\n";

        return result;
    }

    protected String dlcPlus(Film filmDown, Film filmUp, Film filmMidle, int number) {
        // Вычисляется сколько требуется материала
        rollOne = (double) (new CreatePlastic().create(filmDown, number, dlcP)).get(1);

        String result = "На часть " + filmDown + " получится:\n";
        result += "- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2\n";

        String resultOne = String.format("%.2f", (rollOne / 1000));
        result += "Рекомендуется - 1,5х"
                + resultOne + " м. пленки" + System.lineSeparator() + "\n";

        // Вычисляется сколько требуется материала
        rollOne = (double) (new CreatePlastic().create(filmUp, number, dlcP)).get(1);

        result += "На часть " + filmUp + " получится:\n";
        result += "- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2\n";

        String resultTwo = String.format("%.2f", (rollOne / 1000));
        result += "Рекомендуется - 1,5х"
                + resultTwo + " м. пленки" + System.lineSeparator() + "\n";

        // Вычисляется сколько требуется материала
        rollOne = (double) (new CreatePlastic().create(filmMidle, number, dlcP)).get(1);

        result += "На часть " + filmMidle + " получится:\n";
        result += "- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2\n";

        String resultThree = String.format("%.2f", (rollOne / 1000));
        result += "Рекомендуется - 1,5х"
                + resultThree + " м. пленки" + System.lineSeparator() + "\n";

        return result;
    }

    protected String dlc(Film filmDown, Film filmUp, Film filmMidle, int number) {
        // Вычисляется сколько требуется материала
        rollOne = (double) (new CreatePlastic().create(filmDown, number, dlc)).get(1);

        String result = "На часть " + filmDown + " получится:\n";
        result += "- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2\n";

        String resultOne = String.format("%.2f", (rollOne / 1000));
        result += "Рекомендуется - 1,37х"
                + resultOne + " м. пленки" + System.lineSeparator() + "\n";

        // Вычисляется сколько требуется материала
        rollOne = (double) (new CreatePlastic().create(filmUp, number, dlc)).get(1);

        result += "На часть " + filmUp + " получится:\n";
        result += "- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2\n";

        String resultTwo = String.format("%.2f", (rollOne / 1000));
        result += "Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + "\n";

        // Вычисляется сколько требуется материала
        rollOne = (double) (new CreatePlastic().create(filmMidle, number, dlc)).get(1);

        result += "На часть " + filmMidle + " получится:\n";
        result += "- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2\n";

        String resultThree = String.format("%.2f", (rollOne / 1000));
        result += "Рекомендуется - 1,37х"
                + resultThree + " м. пленки" + System.lineSeparator() + "\n";

        return result;
    }

    private String oracal(Film filmDown, Film filmUp, Film filmMidle, int number) {
        String result = plastic(filmDown, number);
        result += plastic(filmUp, number);
        result += plastic(filmMidle, number);

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);

        return result;
    }

    @Override
    protected String plastic(Film film, int number) {
        return super.plastic(film, number);
    }
}
