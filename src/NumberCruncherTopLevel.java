/**
 * ueb 16 - NumberCruncherTopLevel Klasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class NumberCruncherTopLevel {
    float array[];

    public NumberCruncherTopLevel(float[] array) {
        this.array = array;
    }

    public void crunch(String[] operations) {
        for (String operation : operations) {
            if (operation.toLowerCase().equals("sum")) {
                Sum sum = new Sum();
                sum.crunch(array);
            } else if (operation.toLowerCase().equals("swirl")) {
                Swirl swirl = new Swirl();
                swirl.crunch(array);
            } else if (operation.toLowerCase().equals("divide")) {
                Divide divide = new Divide();
                divide.crunch(array);
            } else if (operation.toLowerCase().equals("subtract")) {
                Subtract subtract = new Subtract();
                subtract.crunch(array);
            } else if (operation.toLowerCase().equals("average")) {
                Average average = new Average();
                average.crunch(array);
            }
        }
    }

    public float[] getNumbers() {
        return array;
    }
}
