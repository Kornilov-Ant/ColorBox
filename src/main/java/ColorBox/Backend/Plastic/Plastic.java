package ColorBox.Backend.Plastic;

import lombok.Getter;
import lombok.Setter;

/**
 * Модель для материала "Пленка" рулон
 */
@Getter
@Setter
public class Plastic {

    // При создании задается это поле в конструкторе,
    // характеризующая ширину материала
    private final int x;

    // Сюда сохраняется общая длина требуемого материала
    private double y = 0.0;

    // Константа максимальной длины материала
    private final double z = 500000.0;

    public Plastic(int x) {
        this.x = x;
    }

}
