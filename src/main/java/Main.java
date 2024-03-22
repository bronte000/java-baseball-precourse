import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int[] secretCode = new int[3];

    public static void main(String[] args) {
        System.out.println("게임을 시작합니다.");

        while (true) {
            makeSecretCode(secretCode);
            if (!askNewGame()) {
                break;
            }
        }
    }

    public static void makeSecretCode(int[] secretCode) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            secretCode[i] = random.nextInt(10);
            System.out.println(secretCode[i]);
        }
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
            System.out.println("입력이 잘못되었습니다.");
        }
    }
}
