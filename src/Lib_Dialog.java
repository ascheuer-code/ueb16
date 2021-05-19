import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lib_Dialog {

    private int option = -1;
    private static Scanner input;
    private static int optioncounter;

    /**
     * Eigentliche Startmethode
     * 
     * @param menue     Arrayliste die alle Menuepunkte übergibt
     * @param className Klassenname als String der übergeben wird
     */

    public void start(ArrayList<String> menue, String className) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        input = new Scanner(System.in);
        final int ENDE = Lib_Arrays.countArrayListIndex(menue) + 1;

        Class<?> cls = Class.forName(className);
        Object o = cls.getDeclaredConstructor().newInstance();

        while (option != ENDE) {
            try {
                printMenue(menue);
                option = chooseOption();
                ausfuehrenFunktion(menue, option, o);
            } catch (InputMismatchException msg) {
                System.out.println("\n" + msg + ": Kein korrekter Wert");
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }

    }

    /**
     * Methode zur Ausgabe eines Wahlmenues
     * 
     * @param arraylist Arrayliste anhand der das Menue erstellt wird
     */
    public static void printMenue(ArrayList<String> arraylist) {

        StringBuilder sb = new StringBuilder();
        optioncounter = 0;
        System.out.println("");
        for (String string : arraylist) {

            optioncounter++;
            sb.append(String.format("%d: %s\n", optioncounter, string));

        }
        System.out.println(sb);

    }

    /**
     * Methode für die Optionsabfrage des Menues
     * 
     * @return int Menuepunkt
     */
    public static int chooseOption() {
        input = new Scanner(System.in);
        System.out.print("\nBitte wählen sie eine Option\n");
        return input.nextInt();
    }

    /**
     * Methode zum ausführen der entsprechenden Logik die hinter dem Menuepunkt
     * liegt
     * 
     * @param option Optionsauswahl von chooseOption()
     * @param menue  Arrayliste aus der gewünschte Methodennamen extrahiert wird
     * @param o      Klassenobjekt das übergeben wird
     */
    public static void ausfuehrenFunktion(ArrayList<String> menue, int option, Object o)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Method method = o.getClass().getDeclaredMethod(Lib_String.RemoveAllWhitespaces(menue.get(option - 1)));
        method.invoke(o);
    }

}
