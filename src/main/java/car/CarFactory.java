package car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

	private List<Car> carList = new ArrayList<>();

	List<Car> getCarList() {
		return this.carList;
	}

	public CarFactory add(Car car) {
		carList.add(car);
		return this;
	}
}
