package ColorBox.Frontend.ControlValues;

public class SelectedInside {
    public static int check(String line) {
        switch (line) {
            case "1/1,26":
                return 1;
            case "1,37":
                return 2;
            case "1,5":
                return 3;
            default:
                return 0;
        }
    }
}
