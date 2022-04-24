package racingcar;

public class Rounds {
	private int rounds;

	public Rounds(String size) {
		try {
			int rounds = Integer.parseUnsignedInt(size);
			checkNonZero(rounds);
			this.rounds = rounds;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private void checkNonZero(int rounds) {
		if (rounds == 0)
			throw new IllegalArgumentException("적절하지 않은 rounds");
	}

	public void iterate(Runnable runnable) {
		for (int i = 0; i < rounds; i++) {
			runnable.run();
		}
	}
}
