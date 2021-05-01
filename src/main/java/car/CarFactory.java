package car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CarFactory {

	private List<Car> carList = new ArrayList<>();


	public CarFactory add(Car car) {
		carList.add(car);
		return this;
	}

	public void processAboutCarList(Consumer<Car> consumer){
		for(Car car : this.carList){
			consumer.accept(car);
		}
	}

	public Car getMaxPositionCar(){
		return Collections.max(carList);
	}

	List<Car> getCarList() {
		return this.carList;
	}
}
