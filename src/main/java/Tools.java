import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {

    static Scanner sc = new Scanner(System.in);
    static String readT;

    public int readInt() {

        boolean runAgain = true;
        int readN = -1;

        while (runAgain) {
            try {
                readN = sc.nextInt();
                sc.nextLine();
                runAgain = false;

            } catch (InputMismatchException e) {
                System.out.println("ERROR! Please insert a number");
                sc.nextLine();
            }
        }
        return readN;
    }

    public String readText() {
        readT = sc.nextLine();
        return readT;
    }
}
