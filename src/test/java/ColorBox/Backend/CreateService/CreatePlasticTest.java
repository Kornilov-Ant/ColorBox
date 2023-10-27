package ColorBox.Backend.CreateService;

import ColorBox.Backend.Part.Film;
import ColorBox.Backend.Plastic.Plastic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatePlasticTest {

    @Test
    @DisplayName("Тест CreatePlastic")
    public void createPlasticTest() {
        boolean result = false;
        Film film = new Film(100, 200);
        Plastic plastic = new Plastic(1260);
        CreatePlastic createPlastic = new CreatePlastic();
        if(createPlastic.create(film, 213, plastic).get(0).equals(12) &&
                createPlastic.create(film, 213, plastic).get(1).equals(3550.0)) {
            result = true;
        }
        assertTrue(result);
    }

}
