package ColorBox.Backend.Box;

import lombok.Data;

/**
 * Модель коробки "Двойное дно" с равными бортами
 */
@Data
public class BoxTwoCapLite {

    // Длина упаковки
    private final int x;
    // Ширина упаковки
    private final int y;
    // Высота упаковки
    private final int z;
    // Ширина боковой линии
    private final int g;

}
