package ColorBox.Frontend.ControlValues;

public class SelectedOutside {
    public static int check(String line) {
        switch (line) {
            case "1,37":
                return 0;
            case "1,5":
                return 1;
            default:
                return -1;
        }
    }
}
