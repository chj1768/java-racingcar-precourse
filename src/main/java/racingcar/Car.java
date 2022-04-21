package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Observable;

public class Car extends Observable {
	public static final int LOWER_BOUND = 3;
	public static final int MINIMAL_NUMBER = 0;
	public static final int MAXIMAL_NUMBER = 9;
	private final CarName carName;
	private Status status;

	public Car(CarName carName) {
		this.carName = carName;
		this.status = Status.STOP;
	}

	public boolean isStopped() {
		return status == Status.STOP;
	}

	@Override
	public String toString() {
		return carName.toString();
	}

	public void drive() {
		int number = Randoms.pickNumberInRange(MINIMAL_NUMBER, MAXIMAL_NUMBER);

		this.status = Status.GO;

		if (number <= LOWER_BOUND) {
			this.status = Status.STOP;
		}

		setChanged();
		notifyObservers();
	}
}
