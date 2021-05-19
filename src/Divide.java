import java.util.Arrays;

/**
 * ueb 16 - Divide Top Level Klasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class Divide implements CrunchOperation{
    public void crunch(float values[]) {
        Arrays.sort(values);
        for (int i = 0; i < values.length; i++) {
            if ((values.length - 1 - i) > i) {
                values[values.length - 1 - i] /= values[i];
            }
        }
    }
}
