package ColorBox.Backend.Service.DevelopPlastic;

import ColorBox.Backend.Entity.Box.BoxCap;
import ColorBox.Backend.Entity.Plastic.Plastic;
import ColorBox.Backend.Service.CreateService.CreatePlastic;
import ColorBox.Backend.Entity.Part.Film;

/**
 * Класс, реализующий тех. логику просчета материала Plastic, для сборки упаковки
 */
public class PlasticCap {
    // Создаются объекты пленки с техническими параметрами материала
    protected Plastic oracalBig = new Plastic(1260);
    protected Plastic oracalSmall = new Plastic(1000);
    protected Plastic dlc = new Plastic(1370);
    protected Plastic dlcP = new Plastic(1500);

    // Общие переменные для взаимодействия
    protected double rollOne, rollTwo;
    protected double small = 1.00;
    protected double big = 1.26;

    public String roll(BoxCap box, int number, int plasticSelected) {
        // Задаются размеры для Plastic дно
        Film filmDown = new Film(box.getX() + 38 + (box.getZ() * 2),
                box.getY() + 38 + (box.getZ() * 2));
        // Задаются размеры для Plastic крышка
        Film filmUp = new Film(box.getX() + 43 + (box.getF() * 2),
                box.getY() + 43 + (box.getF() * 2));

        String result = "Оклейка снаружи:" + "\n";

        // В зависимости от выбранного пункта пользователем
        // в блоке case вызывается метод соответствующий материалу
        switch (plasticSelected) {
            case -1:
                result += "материал \"Oracal\"\n";
                result += oracal(filmDown, filmUp, number);
                break;
            case 0:
                result += "материал \"DLC 1.36 м.\"\n";
                result += dlc(filmDown, filmUp, number);
                break;
            case 1:
                result += "материал \"DLC 1.5 м.\"\n";
                result += dlcPlus(filmDown, filmUp, number);
                break;
        }
        result += "" + System.lineSeparator() + "________________________________\n";
        return result;
    }

    private String dlcPlus(Film filmDown, Film filmUp, int number) {
        // Вычисляется сколько требуется материала
        rollOne = (double) (new CreatePlastic().create(filmDown, number, dlcP)).get(1);

        String result = "На часть " + filmDown + " получится:" + "\n";
        result += "- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2" + "\n";

        String resultOne = String.format("%.2f", (rollOne / 1000));
        result += "Рекомендуется - 1,5х"
                + resultOne + " м. пленки" + System.lineSeparator() + "\n";

        // Вычисляется сколько требуется материала
        rollOne = (double) (new CreatePlastic().create(filmUp, number, dlcP)).get(1);

        result += "На часть " + filmUp + " получится:" + "\n";
        result += "- рулон 1,5 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2" + "\n";

        String resultTwo = String.format("%.2f", (rollOne / 1000));

        result += "Рекомендуется - 1,5х"
                + resultTwo + " м. пленки" + System.lineSeparator() + "\n";
        return result;
    }

    private String dlc(Film filmDown, Film filmUp, int number) {
        // Вычисляется сколько требуется материала
        rollOne = (double) (new CreatePlastic().create(filmDown, number, dlc)).get(1);

        String result = "На часть " + filmDown + " получится:" + "\n";
        result += "- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2" + "\n";

        String resultOne = String.format("%.2f", (rollOne / 1000));

        result += "Рекомендуется - 1,37х"
                + resultOne + " м. пленки" + System.lineSeparator() + "\n";

        // Вычисляется сколько требуется материала
        rollOne = (double) (new CreatePlastic().create(filmUp, number, dlcP)).get(1);

        result += "На часть " + filmUp + " получится:" + "\n";
        result += "- рулон 1,37 м. шириной -> "
                + String.format("%.0f", rollOne) + " м2" + "\n";

        String resultTwo = String.format("%.2f", (rollOne / 1000));

        result += "Рекомендуется - 1,37х"
                + resultTwo + " м. пленки" + System.lineSeparator() + "\n";
        return result;
    }

    private String oracal(Film filmDown, Film filmUp, int number) {
        String result = plastic(filmDown, number);    //дно
        result += plastic(filmUp, number);          // крышка

        oracalBig.setY(Math.round(oracalBig.getY() * 100) / 100D);
        oracalSmall.setY(Math.round(oracalSmall.getY() * 100) / 100D);

        return result;
    }

    protected String plastic(Film film, int number) {
        // Вычисляется сколько требуется материала для узкого рулона
        rollOne = (double) (new CreatePlastic().create(film, number, oracalSmall)).get(1);
        // Вычисляется сколько требуется материала для широкого рулона
        rollTwo = (double) (new CreatePlastic().create(film, number, oracalBig)).get(1);

        // Итоговые переменные для сравнения
        Double m22 = rollTwo * big;
        Double m21 = rollOne * small;

        String result = "На часть " + film + " получится:" + "\n";

        result += "- рулон 1 м. шириной -> "
                + String.format("%.0f", m21) + " м2" + "\n";

        result += "- рулон 1,26 м. шириной -> "
                + String.format("%.0f", m22) + " м2" + "\n";

        // Сравниваются переменные, наиболее выгодный вариант по тех. регламенту
        // берется за основу для рекомендации к производству
        if (m21 <= m22) {
            String bRes = String.format("%.2f", (rollOne / 1000));
            result += "Рекомендуется на часть " + film +
                    " - 1х" + bRes + " м. пленки"
                    + System.lineSeparator() + "\n";
        } else {
            String bRes = String.format("%.2f", (rollTwo / 1000));
            result += "Рекомендуется на часть " + film +
                    " - 1,26х" + bRes + " м. пленки" + "\n";
        }
        return result;
    }
}
