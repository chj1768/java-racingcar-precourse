package racingcar;

public class Rounds {
	private int rounds;

	public Rounds(String size) {
		try {
			this.rounds = Integer.parseUnsignedInt(size);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void iterate(Runnable runnable) {
		for (int i = 0; i < rounds; i++) {
			runnable.run();
		}
	}
}
