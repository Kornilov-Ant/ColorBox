package ColorBox.Backend.CreateService;

import ColorBox.Backend.Cartoon.Lux;
import ColorBox.Backend.Part.Board;

public class CreateCartoon {

    private double aX, aY, aXy, bX, bY, bXy, back, aBack;
    private Lux lux = new Lux();

    public double createCartoon(Board slide, int number) {
            aX = lux.getX() / (slide.x + 2);
            aY = lux.getY() / (slide.y + 2);
            aXy = Math.floor(aX) * Math.floor(aY);

            bX = lux.getX() / (slide.y + 2);
            bY = lux.getY() / (slide.x + 2);
            bXy = Math.floor(bX) * Math.floor(bY);

            if (aXy >= bXy) {
                back = aXy;
            } else {
                back = bXy;
            }

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
        return Math.floor((number) / back) + res;
    }
}
