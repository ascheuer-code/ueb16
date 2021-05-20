import java.util.Random;

/**
 * ueb 16 - Swirl Top Level Klasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class Swirl implements CrunchOperation{
    public void crunch(float values[]) {
        int n = values.length;

        while (n > 0) {
            int random1 = new Random().nextInt(values.length);
            int random2 = new Random().nextInt(values.length);
            float x = values[random1];
            values[random1] = values[random2];
            values[random2] = x;
            n--;
        }
    }
}
