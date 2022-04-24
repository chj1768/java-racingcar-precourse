package racingcar;

import java.util.ArrayList;

public class Cars extends ArrayList<Car> {
	public void driveAll() {
		for (Car car : this) {
			car.drive();
		}
	}
}
