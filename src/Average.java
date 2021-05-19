/**
 * ueb 16 - Average Top Level Klasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class Average implements CrunchOperation{
    public void crunch(float values[]) {
        float sum = 0;
        float maxValue = 0;
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
            if (values[i] > maxValue) {
                maxValue = values[i];
                maxIndex = i;
            }
        }
        values[maxIndex] = sum / values.length;
    }
}
