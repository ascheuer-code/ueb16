import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * ueb 16 - NumberCruncherAnonym Klasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class NumberCruncherAnonym {
    private float[] array;
    private ArrayList<Operation> operators;

    /**
     * Konstruktor
     * @param array übergebens Float Array
     */
    public NumberCruncherAnonym(float[] array) {
        this.array = array;
        operators = new ArrayList<Operation>();
        operators.add(sum);
        operators.add(swirl);
        operators.add(divide);
        operators.add(subtract);
        operators.add(average);
    }

    /**
     * Methode zum Entscheiden welche Operation angewendet wird
     * @param operations übergebenes String Array mit den Operatoren
     */
    public void crunch(String[] operations) {
        for (String operation : operations) {
            for (Operation operator : operators) {
                if (operation.toLowerCase().equals(operator.getOperation())) {
                    operator.function();
                }
            }
        }
    }

    public float[] getNumbers() {
        return array;
    }

    /**
     * Anonyme sum Klasse
     */
    Operation sum = new Operation() {
        @Override
        public void function() {
            for (int i = 0; i < array.length - 1; i++) {
                array[i+1] += array[i];
            }
        }

        @Override
        public String getOperation() {
            return "sum";
        }
    };

    /**
     * Anonyme swirl Klasse
     */
    Operation swirl = new Operation() {
        @Override
        public void function() {
            int n = array.length;

            while (n > 0) {
                int random1 = new Random().nextInt(array.length);
                int random2 = new Random().nextInt(array.length);
                float x = array[random1];
                array[random1] = array[random2];
                array[random2] = x;
                n--;
            }
        }

        @Override
        public String getOperation() {
            return "swirl";
        }
    };

    /**
     * Anonyme divide Klasse
     */
    Operation divide = new Operation() {
        @Override
        public void function() {
            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                if ((array.length - 1 - i) > i) {
                    array[array.length - 1 - i] /= array[i];
                }
            }
        }

        @Override
        public String getOperation() {
            return "divide";
        }
    };

    /**
     * Anonyme subtract Klasse
     */
    Operation subtract = new Operation() {
        @Override
        public void function() {
            for (int i = 0; i < array.length - 1; i++) {
                array[i+1] = array[i] - array[i+1];
            }
        }

        @Override
        public String getOperation() {
            return "subtract";
        }
    };

    /**
     * Anonyme average Klasse
     */
    Operation average = new Operation() {
        @Override
        public void function() {
            float sum = 0;
            float maxValue = 0;
            int maxIndex = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
                if (array[i] > maxValue) {
                    maxValue = array[i];
                    maxIndex = i;
                }
            }
            array[maxIndex] = sum / array.length;
        }

        @Override
        public String getOperation() {
            return "average";
        }
    };

    /**
     * Operation Interface
     */
    public interface Operation {
        public void function();
        public String getOperation();
    }
}
