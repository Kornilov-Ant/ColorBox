package ColorBox.Backend.DevelopPlastic;

import ColorBox.Backend.Box.BoxCap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlasticCapTest {

    private final PlasticCap plasticCap = new PlasticCap();

    @Test
    @DisplayName("Тест roll")
    public void rollTest() {
        boolean result = false;
        BoxCap boxCap = new BoxCap(100,200,300,100);
        int number = 250;
        System.out.println(plasticCap.roll(boxCap,number, -1));
        if(plasticCap.roll(boxCap,number, -1) != null &&
                !plasticCap.roll(boxCap,number, -1).equals("") &&
                !plasticCap.roll(boxCap,number, -1).equals(" ")) {
            result = true;
        }
        assertTrue(result);
    }
}
