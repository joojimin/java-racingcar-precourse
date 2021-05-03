package car;

import util.CustomStringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CarFactory {

	private static final String REGEX = ",";

	private final List<Car> carList;

	public CarFactory(String inputData){
		this.carList = createCarList(inputData);
	}

	public void processAboutCarList(Consumer<Car> consumer){
		for(Car car : this.carList){
			consumer.accept(car);
		}
	}

	public Car getMax(){
		return Collections.max(carList);
	}

	List<Car> createCarList(String inputData) {
		List carList = new ArrayList();
		List<String> splitList = CustomStringUtils.split(inputData, REGEX);
		for(String value : splitList){
			carList.add(Car.getInstance(value));
		}
		return Collections.unmodifiableList(carList);
	}

	public List<Car> getCarList() {
		return this.carList;
	}
}
