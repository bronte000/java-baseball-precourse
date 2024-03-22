import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int[] secretCode = new int[3];

    public static void main(String[] args) {
        System.out.println("게임을 시작합니다.");

        boolean doNewGame = true;
        while (doNewGame) {
            makeSecretCode();
            runGame();
            doNewGame = askNewGame();
        }
    }

    public static void makeSecretCode() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            secretCode[i] = random.nextInt(10);
        }
    }

    public static int checkInputValidation(String input) {
        try {
            int userGuess = Integer.parseInt(input);
            if (userGuess >= 100 && userGuess < 1000) {
                return userGuess;
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getUserGuess() {
        System.out.println("숫자를 입력해주세요.");
        int userGuess = checkInputValidation(scanner.nextLine());
        while (userGuess == -1) {
            System.out.println("[Error] 입력이 잘못되었습니다.");
            System.out.println("세자리 숫자를 입력해주세요.");
            userGuess = checkInputValidation(scanner.nextLine());
        }
        return userGuess;
    }

    public static boolean checkUserGuess(int userGuess) {
        int strike = 0;
        int ball = 0;
        for (int i = 2; i >= 0; i--) {
            int num = userGuess % 10;
            if (num == secretCode[i]) {
                strike++;
            }
            if (num == secretCode[(i + 1) % 3] || num == secretCode[(i + 2) % 3]) {
                ball++;
            }
            userGuess = userGuess / 10;
        }
        printResult(strike, ball);
        return strike == 3;
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

    public static void runGame() {
        boolean gameFinished = false;
        while (!gameFinished) {
            int userGuess = getUserGuess();
            gameFinished = checkUserGuess(userGuess);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다!");
        System.out.println("게임 끝!");
    }

    public static boolean askNewGame() {
        String userAnswer;

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            userAnswer = scanner.nextLine();
            if (userAnswer.equals("1")) {
                System.out.println("게임을 새로 시작합니다.");
                return true;
            }
            if (userAnswer.equals("2")) {
                System.out.println("게임을 종료합니다.");
                return false;
            }
            System.out.println("[Error] 입력이 잘못되었습니다.");
        }
    }
}
