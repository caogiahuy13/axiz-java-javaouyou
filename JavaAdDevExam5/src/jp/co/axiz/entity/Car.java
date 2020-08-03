package jp.co.axiz.entity;

/**
 * Carクラス
 */
public class Car {
	private String carName;
	private String bodyColor;
	private int speed;
	private int maxSpeed;

	public Car() {

	}

	public Car(String carName, String bodyColor, int maxSpeed) {
		this.carName = carName;
		this.bodyColor = bodyColor;
		this.maxSpeed = maxSpeed;
	}

	public Car(String carName, String bodyColor, int speed, int maxSpeed) {
		this.carName = carName;
		this.bodyColor = bodyColor;
		this.speed = speed;
		this.maxSpeed = maxSpeed;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getBodyColor() {
		return bodyColor;
	}

	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed < 0 || speed > maxSpeed) {
			System.out.println("現在速度に、この値（" + speed + "）をセットすることはできません");
		} else {
			this.speed = speed;
		}
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed < 0) {
			System.out.println("現在速度に、この値（" + maxSpeed + "）をセットすることはできません");
		} else {
			this.maxSpeed = maxSpeed;
		}
	}

}
