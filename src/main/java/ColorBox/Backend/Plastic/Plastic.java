package ColorBox.Backend.Plastic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plastic {

    private final int x;
    private double y = 0.0;
    private final double z = 500000.0;

    public Plastic(int x) {
        this.x = x;
    }

}
