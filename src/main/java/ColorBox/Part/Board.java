package ColorBox.Part;

public class Board {

    public final int x;
    public final int y;

    public Board(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "x" + y;
    }
}
