import java.util.Random;

public class Swirl implements CrunchOperation{
    public void crunch(float values[]) {
        int n = values.length;
        int random1 = new Random().nextInt(values.length);
        int random2 = new Random().nextInt(values.length);

        while (n > 0) {
            float x = values[random1];
            values[random1] = values[random2];
            values[random2] = x;
            n--;
        }
    }
}
