package car;

public class Car {
	private final String name;
	private int position;

	public Car(final String name){
		this.name = name;
	}

	public int getPosition(){
		return this.position;
	}
	public String getName(){ return this.name; }

	public void go() {
		this.position += 1;
	}

	public String makeResult(){
		return PlayResultMessage.makeMessage(this.name, this.position);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Car car  = (Car)obj;
		return this.name.equals(car.getName());
	}
}
