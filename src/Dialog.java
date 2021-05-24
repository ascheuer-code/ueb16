import java.util.ArrayList;
import java.util.Random;

/**
 * ueb 16 - Dialog Klasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class Dialog {

    private static ArrayList<String> menu1;
    private static ArrayList<String> menu2;
    private static ArrayList<String> menu3;
    private static Object classObject;
    private float[] values;
    private static String[] sum = { "sum" };
    private static String[] swirl = { "swirl" };
    private static String[] divide = { "divide" };
    private static String[] subtract = { "subtract" };
    private static String[] average = { "average" };

    public void start() {

        menu1 = new ArrayList<String>();
        menu2 = new ArrayList<String>();
        menu3 = new ArrayList<String>();
    }

    public static void main(String[] args) {

        new Dialog().start();

        menu1.add("Array manuell befuellen");
        menu1.add("Array zufaellig befuellen");

        menu2.add("Number Cruncher Anonym");
        menu2.add("Cruncher Top Level");
        menu2.add("Ende");

        menu3.add("Sum");
        menu3.add("Swirl");
        menu3.add("Divide");
        menu3.add("Subtract");
        menu3.add("Average");
        menu3.add("Array ausgeben");

        classObject = new Dialog();

        new Lib_Dialog().start(menu1, classObject);
    }

    public void arrayManuellBefuellen() {
        System.out.println();
        System.out.println("ARRAY MANUELL BEFUELLEN:\n");
        System.out.print("Anzahl Werte: ");
        int anzahl = Lib_Dialog.input.nextInt();
        Lib_Digits.checkMin(1, anzahl, "Anzahl Werte:");
        values = new float[anzahl];
        System.out.println();
        for (int i = 0; i < anzahl; i++) {
            System.out.print(i + 1 + ". Zahl: ");
            values[i] = Lib_Dialog.input.nextFloat();
        }
        System.out.print("\nIhr Array: ");
        for (float value : values) {
            System.out.print(value + "  ");
        }
        System.out.println();

        new Lib_Dialog().start(menu2, classObject);
    }

    public void arrayZufaelligBefuellen() {
        System.out.println();
        System.out.println("ARRAY ZUFAELLIG BEFUELLEN:\n");
        System.out.print("Anzahl Werte: ");
        int anzahl = Lib_Dialog.input.nextInt();
        Lib_Digits.checkMin(1, anzahl, "Anzahl Werte:");
        System.out.println();
        System.out.print("min-Wert: ");
        float min = Lib_Dialog.input.nextFloat();
        System.out.print("max-Wert: ");
        float max = Lib_Dialog.input.nextFloat();
        values = new float[anzahl];
        for (int i = 0; i < anzahl; i++) {
            float value = new Random().nextFloat() * (max - min) + min;
            values[i] = value;
        }
        System.out.print("\nIhr Array: ");
        for (float value : values) {
            System.out.print(value + "  ");
        }
        System.out.println();

        new Lib_Dialog().start(menu2, classObject);
    }

    public void numberCruncherAnonym() {
        NumberCruncherAnonym object = new NumberCruncherAnonym(values);
        Lib_Dialog.printMenue(menu3);
        int option = Lib_Dialog.chooseOption();
        switch (option) {
            case 1:
                sum(object);
                break;
            case 2:
                swirl(object);
                break;
            case 3:
                divide(object);
                break;
            case 4:
                substract(object);
                break;
            case 5:
                average(object);
                break;
            case 6:
                printAll(object);
                break;
        }
    }

    public void cruncherTopLevel() {
        NumberCruncherTopLevel object = new NumberCruncherTopLevel(values);
        Lib_Dialog.printMenue(menu3);
        int option = Lib_Dialog.chooseOption();
        switch (option) {
            case 1:
                sum(object);
                break;
            case 2:
                swirl(object);
                break;
            case 3:
                divide(object);
                break;
            case 4:
                substract(object);
                break;
            case 5:
                average(object);
                break;
            case 6:
                printAll(object);
                break;
        }
    }

    private void printAll(NumberCruncherTopLevel object) {
        System.out.println();
        float numbers[] = object.getNumbers();
        for (float number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private void average(NumberCruncherTopLevel object) {
        System.out.println();
        object.crunch(average);
        System.out.println("Operator Average wurde angewendet");
    }

    private void substract(NumberCruncherTopLevel object) {
        System.out.println();
        object.crunch(subtract);
        System.out.println("Operator Subtract wurde angewendet");
    }

    private void divide(NumberCruncherTopLevel object) {
        System.out.println();
        object.crunch(divide);
        System.out.println("Operator Divide wurde angewendet");
    }

    private void swirl(NumberCruncherTopLevel object) {
        System.out.println();
        object.crunch(swirl);
        System.out.println("Operator Swirl wurde angewendet");
    }

    private void sum(NumberCruncherTopLevel object) {
        System.out.println();
        object.crunch(sum);
        System.out.println("Operator Sum wurde angewendet");
    }

    private void printAll(NumberCruncherAnonym object) {
        System.out.println();
        float numbers[] = object.getNumbers();
        for (float number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private void average(NumberCruncherAnonym object) {
        System.out.println();
        object.crunch(average);
        System.out.println("Operator Average wurde angewendet");
    }

    private void substract(NumberCruncherAnonym object) {
        System.out.println();
        object.crunch(subtract);
        System.out.println("Operator Subtract wurde angewendet");
    }

    private void divide(NumberCruncherAnonym object) {
        System.out.println();
        object.crunch(divide);
        System.out.println("Operator Divide wurde angewendet");
    }

    private void swirl(NumberCruncherAnonym object) {
        System.out.println();
        object.crunch(swirl);
        System.out.println("Operator Swirl wurde angewendet");
    }

    private void sum(NumberCruncherAnonym object) {
        System.out.println();
        object.crunch(sum);
        System.out.println("Operator Sum wurde angewendet");
    }

    public void ende() {
        System.exit(0);
    }

}
