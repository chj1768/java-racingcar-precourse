package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {
	@ParameterizedTest
	@NullAndEmptySource
	void 차_이름은_널이나_빈_문자열_형태가_될_수_없다(String input) {
		Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new CarName(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"123456", "      ", "******", "#$%^$-", "😀😀😀"})
	void 차_이름은_5자_초과는_불가능하다(String input) {
		Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new CarName(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "12345", "     ", "*", "#$%^$", "😀", "😀😀"})
	void 차_이름은_5자_이하만_가능하다(String input) {
		Assertions.assertDoesNotThrow(() -> new CarName(input));
	}
}
