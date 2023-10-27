package ColorBox.Backend.Box;

import lombok.Data;

/**
 * Модель коробки "Двойное дно" с разными бортами
 */
@Data
public class BoxTwoCap {

    // Длина упаковки
    private final int x;
    // Ширина упаковки
    private final int y;
    // Высота упаковки
    private final int z;
    // Высота внутреннего борта
    private final int f;
    // Высота внешнего нижнего борта
    private final int g;
    // Ширина боковой линии
    private final int h;

}
