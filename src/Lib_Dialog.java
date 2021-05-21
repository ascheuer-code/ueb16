import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/* In die Main einfügen
*
* Class<?> cls = Class.forName("klassennamen");
        classObject = cls.getDeclaredConstructor().newInstance();

        new Lib_Dialog().start(menu1, classObject);
*
*/

public class Lib_Dialog {

    private int option = -1;
    public static Scanner input;
    private static int optioncounter;

    /**
     * Eigentliche Startmethode
     */

    public void start(ArrayList<String> menue, Object o) {

        input = new Scanner(System.in);
        final int ENDE = -5;

        while (option != ENDE) {
            try {
                printMenue(menue);
                option = chooseOption();
                ausfuehrenFunktion(menue, option, o);
            } catch (InputMismatchException msg) {
                System.out.println("\n" + msg + ": Kein korrekter Wert");
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    /**
     * Methode zur Ausgabe eines Wahlmenues
     * 
     * @param arraylist Arrayliste anhand der das Menue erstellt wird
     */

    public static <T> void printMenue(ArrayList<T> arraylist) {

        StringBuilder sb = new StringBuilder();
        optioncounter = 0;
        System.out.println("");
        for (T string : arraylist) {

            optioncounter++;
            sb.append(String.format("%d: %s\n", optioncounter, string));

        }
        System.out.println(sb);

    }

    /**
     * Methode für die Optionsanfrage des Menues
     * 
     * @return int Menuepunkt
     */

    public static int chooseOption() {

        System.out.print("\nPlease choose a Option\n");

        return input.nextInt();

    }

    /**
     * Methode zum ausführen der entsprechenden Logik die hinter dem Menuepunkt
     * liegt
     * 
     * @param option Optionsauswahl von chooseOption()
     */

    public static void ausfuehrenFunktion(ArrayList<String> menue, int option, Object o)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Lib_Digits.checkSpan(0, menue.size(), option, "Option");
        Method method = o.getClass().getMethod(Lib_String.menueToMethod(menue.get(option - 1)));
        method.invoke(o);
    }

}
