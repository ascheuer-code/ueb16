public class Sum implements CrunchOperation{
    public void crunch(float values[]) {
        for (int i = 0; i < values.length - 1; i++) {
            values[i+1] += values[i];
        }
    }
}
