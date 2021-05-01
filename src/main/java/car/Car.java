package car;

public class Car {
	private int position;

	public int getPosition(){
		return this.position;
	}

	public void go() {
		this.position += 1;
	}
}
