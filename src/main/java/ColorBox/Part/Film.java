package ColorBox.Part;

import lombok.Data;

@Data
public class Film {

    public final int x;
    public final int y;

    @Override
    public String toString() {
        return x + "x" + y;
    }
}
