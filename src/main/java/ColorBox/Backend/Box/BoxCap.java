package ColorBox.Backend.Box;

import lombok.Data;

/**
 * Модель коробки "Крышка-дно"
 */
@Data
public class BoxCap {

    // Длина упаковки
    private final int x;
    // Ширина упаковки
    private final int y;
    // Высота упаковки
    private final int z;
    // Высота крышки
    private final int f;

}
