package ColorBox.Part;

public class Film {

    public final int x;
    public final int y;

    public Film(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "x" + y;
    }
}
