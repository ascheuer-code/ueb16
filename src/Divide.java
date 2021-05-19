import java.util.Arrays;

public class Divide implements CrunchOperation{
    public void crunch(float values[]) {
        Arrays.sort(values);
        for (int i = 0; i < values.length; i++) {
            values[values.length - 1 - i] /= values[i];
        }
    }
}
