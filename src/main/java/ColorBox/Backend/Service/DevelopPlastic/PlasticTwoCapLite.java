package ColorBox.Backend.Service.DevelopPlastic;

import ColorBox.Backend.Entity.Box.BoxTwoCapLite;
import ColorBox.Backend.Entity.Part.Film;

/**
 * Класс, реализующий тех. логику просчета материала Plastic,
 * для сборки упаковки "Двойное дно с разными бортами"
 */
public class PlasticTwoCapLite extends PlasticTwoCap {

    public String roll(BoxTwoCapLite box, int number, int plasticSelected) {
        // Задаются размеры для Plastic внутренний каркас
        Film filmMiddle = new Film(
                box.getX() + 38 + ((box.getZ() + 2) * 2),
                box.getY() + 38 + ((box.getZ() + 2) * 2)
        );
        // Задаются размеры для Plastic крышка
        Film filmUp = new Film(
                (box.getX() + 5) + 38 + ((box.getZ() - box.getG()) * 2),
                (box.getY() + 5) + 38 + ((box.getZ() - box.getG()) * 2)
        );
        // Задаются размеры для Plastic дно
        Film filmDown = filmUp;

        String result = "Оклейка снаружи:\n";

        // В зависимости от выбранного пункта пользователем
        // в блоке case вызывается метод соответствующий материалу
        switch (plasticSelected) {
            case -1:
                result += "материал \"DLC 1.5 м.\"\n";
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
        return super.dlcPlus(filmDown, filmUp, filmMidle, number);
    }

    protected String dlc(Film filmDown, Film filmUp, Film filmMidle, int number) {
        return super.dlc(filmDown, filmUp, filmMidle, number);
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
