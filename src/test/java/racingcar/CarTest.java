package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Observable;

public class CarTest {
	private static class MockCar extends Car {
		private boolean isCalled = false;

		public MockCar() {
			super(new CarName("mock"));
		}

		@Override
		public void notifyObservers(Object arg) {
			super.notifyObservers(arg);
			this.isCalled = true;
		}

		public boolean isNotifyObserversCalled() {
			return isCalled;
		}
	}

	@Test
	void 차는_차_이름을_갖는_Obervable_객체이다() {
		CarName carName = new CarName("차이름");
		Car car = new Car(carName);
		Assertions.assertTrue(car instanceof Observable);
	}

	@Test
	void 차는_동작을_옵저버에게_알린다() {
		MockCar car = new MockCar();
		Assertions.assertFalse(car.isNotifyObserversCalled());

		car.drive();

		Assertions.assertTrue(car.isNotifyObserversCalled());
	}
}
