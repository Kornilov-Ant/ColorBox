package ColorBox.Backend.Service.CreateService;

import ColorBox.Backend.Entity.Part.Film;
import ColorBox.Backend.Entity.Plastic.Plastic;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, в котором реализована тех. логика размещения материала Plastic
 */
public class CreatePlastic {
    private double rollDown, rollUp, aD, aU, bD, bU;

    public List<Number> create(Film film, int number, Plastic plastic){
        List<Number> list = new ArrayList<>();
        // Ниже изделия раскладываются по горизонтали
        aD = Math.floor(plastic.getZ() / film.x);
        aU = Math.floor(plastic.getX() / film.y); // CONST
        // Ниже изделия раскладываются по вертикали
        bD = Math.floor(plastic.getZ() / film.y);
        bU = Math.floor(plastic.getX() / film.x); // CONST

        // Вычисляется максимальное покрытие изделием
        rollUp = aD * aU;
        rollDown = bD * bU;

        // Решается в какой ориентации умещается больше изделий
        if (aU >= bU) {
            list.add((int) aU);
        } else {
            list.add((int) bU);
        }

        // В соответствии с этим, более выгодный вариант
        // добавляется в коллекцию и метод возвращает ее
        if (rollUp >= rollDown) {
            aD = number / Math.floor(plastic.getX() / film.y);
            list.add(aD * film.x);
        } else {
            bU = number / Math.floor(plastic.getX() / film.x);
            list.add(bU * film.y);
        }
        return list;
    }
}
