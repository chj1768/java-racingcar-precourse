package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Observable;

public class Car extends Observable {
	private final CarName carName;

	public Car(CarName carName) {
		this.carName = carName;
	}

	public void drive() {
		int number = Randoms.pickNumberInRange(0, 9);

		if (number <= 3) {
			notifyObservers(Status.STOP);
			return;
		}

		notifyObservers(Status.GO);
	}
}
