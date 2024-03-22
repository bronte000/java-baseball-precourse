import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    static void setSecretCode(int n1, int n2, int n3) {
        Main.secretCode[0] = n1;
        Main.secretCode[1] = n2;
        Main.secretCode[2] = n3;
    }

    @Test
    void testCheckUserGuess() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int secret1 = random.nextInt(10);
            int secret2 = random.nextInt(10);
            int secret3 = random.nextInt(10);
            setSecretCode(secret1, secret2, secret3);
            for (int j = 0; j < 100; j++) {
                int user1 = random.nextInt(10);
                int user2 = random.nextInt(10);
                int user3 = random.nextInt(10);
                int userGuess = user1 * 100 + user2 * 10 + user3;

                boolean isAnswer = secret1 == user1 && secret2 == user2 && secret3 == user3;
                assertThat(Main.checkUserGuess(userGuess))
                        .isEqualTo(isAnswer);
            }
        }
    }
}
