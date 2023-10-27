package ColorBox.Backend.CheckService.ControlValues;

/**
 * Класс с единственным методом, который
 * проверяет строку на соответствие заранее добавленным значениям
 * и возвращает числовой код проверки
 */
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
