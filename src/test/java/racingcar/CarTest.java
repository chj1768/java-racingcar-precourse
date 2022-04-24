package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.MockCar;

import java.util.Observable;

public class CarTest {
	@Test
	void 차는_차_이름을_갖는_Obervable_객체이다() {
		CarName carName = new CarName("차이름");
		Car car = new Car(carName);
		Assertions.assertTrue(car instanceof Observable);
	}

	@Test
	void 차는_동작을_옵저버에게_알린다() {
		MockCar car = new MockCar(new CarName("mock"));
		Assertions.assertFalse(car.isNotifyObserversCalled());

		car.drive();

		Assertions.assertTrue(car.isNotifyObserversCalled());
	}
}
