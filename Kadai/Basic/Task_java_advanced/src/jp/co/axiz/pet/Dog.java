package jp.co.axiz.pet;

public class Dog extends Animal {
	String walkingPlace;

	public Dog() {

	}

	public Dog(String name, int age, int height, int weight, String type, String walkingPlace) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.type = type;
		this.walkingPlace = walkingPlace;
	}

	@Override
	public boolean isFat() {
		return (weight > 15) ? true : false;
	}

	public String getWalkingPlace() {
		return walkingPlace;
	}

	public void setWalkingPlace(String walkingPlace) {
		this.walkingPlace = walkingPlace;
	}

}
