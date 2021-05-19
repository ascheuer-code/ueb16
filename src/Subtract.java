/**
 * ueb 16 - Subtract Top Level Klasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class Subtract implements CrunchOperation{
    public void crunch(float values[]) {
        for (int i = 0; i < values.length - 1; i++) {
            values[i+1] = values[i] - values[i+1];
        }
    }
}
