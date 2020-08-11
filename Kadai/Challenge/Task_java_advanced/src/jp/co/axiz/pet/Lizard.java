package jp.co.axiz.pet;

public class Lizard extends Reptile {

	public Lizard() {

	}

	public Lizard(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public boolean isDangerous() {
		return true;
	}

}
