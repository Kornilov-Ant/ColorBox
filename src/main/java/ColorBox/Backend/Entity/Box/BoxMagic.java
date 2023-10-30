package ColorBox.Backend.Entity.Box;

import lombok.Data;

/**
 * Модель коробки "Шкатулка"
 */
@Data
public class BoxMagic {

    // Длина упаковки
    private final int x;
    // Ширина упаковки
    private final int y;
    // Высота упаковки
    private final int z;
    // Высота крышки
    private final int f;

}
