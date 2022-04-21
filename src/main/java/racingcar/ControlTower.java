package racingcar;

import java.util.Observable;
import java.util.Observer;

public class ControlTower implements Observer {
	private static final int STARTING_POINT = 0;

	private final Locations locations;

	public ControlTower(Cars cars) {
		Locations locations = new Locations();

		for (Car car : cars) {
			car.addObserver(this);
			locations.put(car, STARTING_POINT);
		}

		this.locations = locations;
	}

	@Override
	public void update(Observable o, Object arg) {
		Car car = (Car) o;
		if (!car.isStopped()) {
			locations.put(car, locations.getOrDefault(car, STARTING_POINT) + 1);
		}
	}
}
