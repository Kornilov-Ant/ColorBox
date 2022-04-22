package ColorBox.Part;

import lombok.Data;

@Data
public class Board {

    public final int x;
    public final int y;

    @Override
    public String toString() {
        return x + "x" + y;
    }
}
