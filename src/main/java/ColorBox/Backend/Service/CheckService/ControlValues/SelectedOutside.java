package ColorBox.Backend.Service.CheckService.ControlValues;

/**
 * Класс с единственным методом, который
 * проверяет строку на соответствие заранее добавленным значениям
 * и возвращает числовой код проверки
 */
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
