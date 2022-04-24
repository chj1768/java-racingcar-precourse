package racingcar;

import java.util.Collections;
import java.util.LinkedHashMap;

public class Locations extends LinkedHashMap<Car, Position> {
	public Locations(Cars cars) {
		for (Car car : cars) {
			this.put(car, new Position());
		}
	}

	public Position getPosition(Car car) {
		Position position = this.get(car);
		if (position == null)
			throw new IllegalArgumentException("컨트롤타워가 관찰중인 자동차가 아닙니다.");

		return position;
	}

	public void update(Car car) {
		Position position = getPosition(car);
		if (!car.isStopped())
			position.right();
	}

	public Cars getAll() {
		Cars cars = new Cars();
		cars.addAll(this.keySet());
		return cars;
	}

	public Cars winners() {
		Position winner = getWinner();
		Cars cars = getAll();
		Cars winners = new Cars();
		for (Car car : cars) {
			checkAndSetWinner(winner, car, winners);
		}
		return cars;
	}

	private Position getWinner() {
		return Collections.max(this.values());
	}

	private void checkAndSetWinner(Position winner, Car car, Cars winners) {
		if (winner.compareTo(this.get(car)) == 0)
			winners.add(car);
	}
}
