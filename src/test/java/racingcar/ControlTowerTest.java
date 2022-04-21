package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Observable;
import java.util.Observer;

public class ControlTowerTest {
	private static class MockControlTower extends ControlTower {
		private boolean isReceived = false;

		MockControlTower(Cars cars) {
			super(cars);
		}

		public boolean isReceivedObservable() {
			return this.isReceived;
		}

		@Override
		public void update(Observable o, Object arg) {
			this.isReceived = true;
		}
	}

	@Test
	void 컨트롤타워는_Observer_이다() {
		Assertions.assertTrue(new ControlTower(new Cars()) instanceof Observer);
	}

	@Test
	void 컨트롤타워는_Observable_에게_상태를_전달받는다() {
		Car carA = new Car(new CarName("A"));
		Cars cars = new Cars();
		cars.add(carA);
		MockControlTower controlTower = new MockControlTower(cars);
		Assertions.assertFalse(controlTower.isReceivedObservable());

		carA.drive();

		Assertions.assertTrue(controlTower.isReceivedObservable());
	}
}
