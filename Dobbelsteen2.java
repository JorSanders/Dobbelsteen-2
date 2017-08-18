package dobbelsteen2;

/**
 * dobbelsteen 2.0 gooit een dobbelsteen todat je 6 heb gegooid.
 *
 * @author jor
 */
import java.util.*;

public class Dobbelsteen2 {

    static Scanner stdin = new Scanner(System.in);
    static char eyeOfDice;

    public static void main(String[] args) {
        int amountThrown, min, max;

        // Calls for the method that reads which char the user wants as eye
        readEyeChar(); 

        min = 1;
        max = 6;
        do {
            amountThrown = min + (int) (Math.random() * ((max - min) + 1));
            printTheDice(amountThrown);//calls for the method which prints a fancy dice face
        } while (amountThrown != 6);
    }

    //method which reads a character 
    public static void readEyeChar() {
        System.out.print("What character do you want to use as eye for the dice? ");
        eyeOfDice = stdin.next().charAt(0);
        System.out.println("");
    }

    //method which takes in a number and accordingly draws a dice face
    public static void printTheDice(int amountThrown) {
        Boolean[][] PrintThisEye = new Boolean[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                PrintThisEye[i][j] = false;
            }
        }

        switch (amountThrown) {
            case 1:
                PrintThisEye[1][1] = true;
                break;
            case 2:
                PrintThisEye[0][2] = true;
                PrintThisEye[2][0] = true;
                break;
            case 3:
                PrintThisEye[0][0] = true;
                PrintThisEye[1][1] = true;
                PrintThisEye[2][2] = true;
                break;
            case 4:
                PrintThisEye[0][0] = true;
                PrintThisEye[0][2] = true;
                PrintThisEye[2][0] = true;
                PrintThisEye[2][2] = true;
                break;
            case 5:
                PrintThisEye[0][0] = true;
                PrintThisEye[0][2] = true;
                PrintThisEye[1][1] = true;
                PrintThisEye[2][0] = true;
                PrintThisEye[2][2] = true;
                break;
            case 6:
                PrintThisEye[0][0] = true;
                PrintThisEye[0][2] = true;
                PrintThisEye[1][0] = true;
                PrintThisEye[1][2] = true;
                PrintThisEye[2][0] = true;
                PrintThisEye[2][2] = true;
                break;
            default:
                System.out.println("something went wrong!");
                break;
        }
        System.out.println("-----");
        for (int i = 0; i < 3; i++) {

            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (PrintThisEye[i][j]) {
                    System.out.print(eyeOfDice);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----\n");
    }
}
