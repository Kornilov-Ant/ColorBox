package ColorBox.Backend.Entity.Part;

import lombok.Data;

/**
 * Модель материла "Cartoon" прямоугольник
 */
@Data
public class Board {

    public final int x;
    public final int y;

    @Override
    public String toString() {
        return x + "x" + y;
    }
}
