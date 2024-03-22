import java.util.Random;

public class Util {
    public static void makeSecretCode(int[] secretCode) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            secretCode[i] = random.nextInt(10);
        }
    }

    public static int checkInputValidation(String input) {
        if (input.length() != 3) return -1;
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("Nothing");
            return;
        }
        if (strike == 0) {
            System.out.printf("%d Ball%n", ball);
            return;
        }
        if (ball == 0) {
            System.out.printf("%d Strike%n", strike);
            return;
        }
        System.out.printf("%d Strike, %d Ball%n", strike, ball);
    }
}
