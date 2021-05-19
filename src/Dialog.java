import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dialog extends Lib_Dialog {
    private Scanner scanner;
    private static ArrayList<String> menu1 = new ArrayList<String>();
    private static ArrayList<String> menu2 = new ArrayList<String>();
    private static ArrayList<String> menu3 = new ArrayList<String>();
    private int option1;
    private int option2;
    private int option3 = -1;
    private float[] values;
    private String[] sum = {"sum"};
    private String[] swirl = {"swirl"};
    private String[] divide = {"divide"};
    private String[] subtract = {"subtract"};
    private String[] average = {"average"};

    public void start() {
        scanner = new Scanner(System.in);
        option1 = startMenu1();
        if (option1 == 1) {
            arrayManuell();
        } else {
            arrayRandom();
        }

        option2 = startMenu2();

        menu3.add("Sum");
        menu3.add("Swirl");
        menu3.add("Divide");
        menu3.add("Subtract");
        menu3.add("Average");
        menu3.add("Array ausgeben");
        menu3.add("Ende"); 

        if (option2 == 1) {
            NumberCruncherAnonym object = new NumberCruncherAnonym(values);
            while (option3 != 7) {
                option3 = startMenu3();
                switch(option3) {
                    case 1: 
                        System.out.println();
                        object.crunch(sum);
                        System.out.println("Operator Sum wurde angewendet");
                        break;
                    case 2:
                        System.out.println();
                        object.crunch(swirl);
                        System.out.println("Operator Swirl wurde angewendet");
                        break;
                    case 3:
                        System.out.println();
                        object.crunch(divide);
                        System.out.println("Operator Divide wurde angewendet");
                        break;
                    case 4:
                        System.out.println();
                        object.crunch(subtract);
                        System.out.println("Operator Subtract wurde angewendet");
                        break;
                    case 5:
                        System.out.println();
                        object.crunch(average);
                        System.out.println("Operator Average wurde angewendet");
                        break;
                    case 6:
                        System.out.println();
                        float numbers[] = object.getNumbers();
                        for (float number : numbers) {
                            System.out.print(number + "  ");
                        }
                        System.out.println();
                        break;
                }
            }
        } else {
            NumberCruncherTopLevel object = new NumberCruncherTopLevel(values);
            while (option3 != 7) {
                option3 = startMenu3();
                switch(option3) {
                    case 1: 
                        System.out.println();
                        object.crunch(sum);
                        System.out.println("Operator Sum wurde angewendet");
                        break;
                    case 2:
                        System.out.println();
                        object.crunch(swirl);
                        System.out.println("Operator Swirl wurde angewendet");
                        break;
                    case 3:
                        System.out.println();
                        object.crunch(divide);
                        System.out.println("Operator Divide wurde angewendet");
                        break;
                    case 4:
                        System.out.println();
                        object.crunch(subtract);
                        System.out.println("Operator Subtract wurde angewendet");
                        break;
                    case 5:
                        System.out.println();
                        object.crunch(average);
                        System.out.println("Operator Average wurde angewendet");
                        break;
                    case 6:
                        System.out.println();
                        float numbers[] = object.getNumbers();
                        for (float number : numbers) {
                            System.out.print(number + "  ");
                        }
                        System.out.println();
                        break;
                }
            }
        }
    }

    public int startMenu1() {
        System.out.println();
        System.out.println("ARRAY BEFUELLEN:");
        menu1.add("Array manuell befüllen");
        menu1.add("Array zufällig befüllen");
        printMenue(menu1);
        return chooseOption();
    }

    public void arrayManuell() {
        System.out.println();
        System.out.println("ARRAY MANUELL BEFUELLEN:\n");
        System.out.print("Anzahl Werte: ");
        int anzahl = scanner.nextInt();
        values = new float[anzahl];
        System.out.println();
        for (int i = 0; i < anzahl; i++) {
            System.out.print(i+1 + ". Zahl: ");
            values[i] = scanner.nextFloat();
        }
        System.out.print("\nIhr Array: ");
        for (float value : values) {
            System.out.print(value + "  ");
        }
        System.out.println();
    }

    public void arrayRandom() {
        System.out.println();
        System.out.println("ARRAY ZUFAELLIG BEFUELLEN:\n");
        System.out.print("Anzahl Werte: ");
        int anzahl = scanner.nextInt();
        System.out.println();
        System.out.print("min-Wert: ");
        float min = scanner.nextFloat();
        System.out.print("max-Wert: ");
        float max = scanner.nextFloat();
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
    }

    public int startMenu2() {
        System.out.println();
        System.out.println("KLASSE WAEHLEN:");
        menu2.add("NumberCruncherAnonym");
        menu2.add("CruncherTopLevel");
        printMenue(menu2);
        return chooseOption();
    }

    public int startMenu3() {
        System.out.println();
        System.out.println("OPERATOR WAEHLEN:");
        printMenue(menu3);
        return chooseOption();
    }

    public void ausfuehrenMenu3(int option) {
        
    }
    public static void main(String[] args) {
        new Dialog().start();
    }
}
