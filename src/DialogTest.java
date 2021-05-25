import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class DialogTest {

    private static String[] sum = { "sum" };
    private static String[] swirl = { "swirl" };
    private static String[] divide = { "divide" };
    private static String[] subtract = { "subtract" };
    private static String[] average = { "average" };

    @Test
    public void test() {

        float[] values = { 2, 4, 6 };

        NumberCruncherTopLevel object = new NumberCruncherTopLevel(values);

        // Test für Sum
        object.crunch(sum);
        assertEquals(2.0, values[0]);
        assertEquals(6.0, values[1]);
        assertEquals(12.0, values[2]);

        // Test für Divide
        object.crunch(divide);
        assertEquals(2.0, values[0]);
        assertEquals(6.0, values[1]);
        assertEquals(6.0, values[2]);

        // Test für Subtract
        object.crunch(subtract);
        assertEquals(2.0, values[0]);
        assertEquals(-4.0, values[1]);
        assertEquals(-10.0, values[2]);

        // Test für Average
        object.crunch(average);
        assertEquals(-4.0, values[0]);
        assertEquals(-4.0, values[1]);
        assertEquals(-10.0, values[2]);

    }
}
