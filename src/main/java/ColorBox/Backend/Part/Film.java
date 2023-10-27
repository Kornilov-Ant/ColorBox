package ColorBox.Backend.Part;

import lombok.Data;

/**
 * Модель материла "Plastic" прямоугольник
 */
@Data
public class Film {

    public final int x;
    public final int y;

    @Override
    public String toString() {
        return x + "x" + y;
    }
}
