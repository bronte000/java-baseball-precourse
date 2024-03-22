import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    @Test
    void testCheckInputValidation() {
        assertThat(Util.checkInputValidation("000")).isEqualTo(0);
        assertThat(Util.checkInputValidation("010")).isEqualTo(10);
        assertThat(Util.checkInputValidation("123")).isEqualTo(123);
        assertThat(Util.checkInputValidation("900")).isEqualTo(900);
        assertThat(Util.checkInputValidation("99")).isEqualTo(-1);
        assertThat(Util.checkInputValidation("10")).isEqualTo(-1);
        assertThat(Util.checkInputValidation("11a")).isEqualTo(-1);
    }
}
