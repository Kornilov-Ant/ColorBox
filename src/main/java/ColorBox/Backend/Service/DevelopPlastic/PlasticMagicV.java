package ColorBox.Backend.Service.DevelopPlastic;

import ColorBox.Backend.Entity.Box.BoxMagic;
import ColorBox.Backend.Entity.Part.Film;

/**
 * Класс, реализующий тех. логику просчета материала Plastic,
 * для сборки упаковки "Шкатулка вертикальная"
 */
public class PlasticMagicV extends PlasticMagicG {

    public String roll(BoxMagic box, int number, int plasticSelected) {
        // Задаются размеры для Plastic дно
        Film filmDown = new Film(box.getX() + 40 + (box.getZ() * 2),
                box.getY() + 40 + (box.getZ() * 2));
        // Задаются размеры для Plastic крышка
        Film filmUp = new Film(box.getY() + 40,
                ((box.getX() + 7) * 2) + (box.getF()) + (box.getZ() + 6) + 30);
        // Задаются размеры для Plastic внутренний каркас
        Film filmBack = new Film(box.getY(),
                box.getF() + 6 + box.getX() + 7 + 40);

        String result = "Оклейка снаружи:\n";

        // В зависимости от выбранного пункта пользователем
        // в блоке case вызывается метод соответствующий материалу
        switch (plasticSelected) {
            case -1:
                result += "материал \"Oracal\"\n";
                result += oracal(filmDown, filmUp, filmBack, number);
                break;
            case 0:
                result += "материал \"DLC 1.36 м.\"\n";
                result += dlc(filmDown, filmUp, filmBack, number);
                break;
            case 1:
                result += "материал \"DLC 1.5 м.\"\n";
                result += dlcPlus(filmDown, filmUp, filmBack, number);
                break;
        }

        result += "" + System.lineSeparator() + "________________________________\n";

        return result;
    }

    protected String dlcPlus(Film filmDown, Film filmUp, Film filmBack, int number) {
        return super.dlcPlus(filmDown, filmUp, filmBack, number);
    }

    protected String dlc(Film filmDown, Film filmUp, Film filmBack, int number) {
        return super.dlc(filmDown, filmUp, filmBack, number);
    }

    private String oracal(Film filmDown, Film filmUp, Film filmBack, int number) {
        String result = plastic(filmDown, number);    //дно
        result += plastic(filmUp, number);      // крышка
        result += plastic(filmBack, number);    // вклейка внутри

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);
        return result;
    }

    @Override
    protected String plastic(Film film, int number) {
        return super.plastic(film, number);
    }
}
