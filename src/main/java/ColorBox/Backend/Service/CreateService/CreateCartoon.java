package ColorBox.Backend.Service.CreateService;

import ColorBox.Backend.Entity.Cartoon.Lux;
import ColorBox.Backend.Entity.Part.Board;

/**
 * Класс, в котором реализован подсчет требуемого материала Cartoon
 */
public class CreateCartoon {

    private double aX, aY, aXy, bX, bY, bXy, back;
    private Lux lux = new Lux();

    public double createCartoon(Board slide, int number) {
        // Сколько объектов уместится при горизонтальном расположении
        aX = lux.getX() / (slide.x + 2);
        aY = lux.getY() / (slide.y + 2);
        aXy = Math.floor(aX) * Math.floor(aY);

        // Сколько объектов уместится при вертикальном расположении
        bX = lux.getX() / (slide.y + 2);
        bY = lux.getY() / (slide.x + 2);
        bXy = Math.floor(bX) * Math.floor(bY);

        // Сравнение расположений, для выбора наиболее выгодного
        // и присвоение его переменной back
        if (aXy >= bXy) {
            back = aXy;
        } else {
            back = bXy;
        }

        // Ниже идут тех. округления расходуемого материла
        // в зависимости от степени
        double res = ((number) / back) % 1;

        if (res == 0.0) {
            res = 0.0;
        } else if (res > 0.0 && res <= 0.3) {
            res = 0.3;
        } else if (res > 0.3 && res < 0.6) {
            res = 0.6;
        } else if (res >= 0.6) {
            res = 1.0;
        }

        // Возвращается итог подсчета
        return Math.floor((number) / back) + res;
    }
}
