package ColorBox.Backend.Controller;

import ColorBox.Backend.Service.BoxService;
import ColorBox.Backend.Service.Impl.BoxServiceImpl;

public class BoxController {

    private final BoxService boxService = new BoxServiceImpl();

    public String rest(String line) {
        if (line != null && line.length() > 0) {
            return boxService.update(line.split("&"));
        } else {
            return "ERROR";
        }
    }
}
