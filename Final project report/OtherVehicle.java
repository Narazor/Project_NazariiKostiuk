public abstract class OtherVehicle extends Vehicle {

	protected double speed;

	public OtherVehicle() {
		x = generate_X_Random(1200, 1500);
		y = generate_Y_Random(10, 450);
	}

	protected int generate_Y_Random(int min, int max) {
		return (int) (min + (max - min) * Math.random());
	}

	protected int generate_X_Random(int min, int max) {
		return (int) (min + (max - min) * Math.random());
	}

	protected boolean isPassed() {
		return (getX() + getWidth()) < 0;
	}

	public void move() {
		if (isPassed()) {
			x = generate_X_Random(1200, 3500);
			y = generate_Y_Random(20, 450);
		} else {
			x -= getSpeed();
		}
	}

	protected abstract int getSpeed();

}
