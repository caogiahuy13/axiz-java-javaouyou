package app;

public class Rabbit extends Animal {
	public Rabbit() {

	}

	public Rabbit(String name, int age) {
		super(name, age);
	}

	@Override
	public String introduceAge() {
		String animalAge = "";

		if (age > 5) {
			animalAge = "60歳以上";
		} else if (age >= 5) {
			animalAge = "50代";
		} else if (age >= 4) {
			animalAge = "40代";
		} else if (age >= 3) {
			animalAge = "30代";
		} else if (age >= 2) {
			animalAge = "20代";
		} else if (age >= 1) {
			animalAge = "10代";
		} else {
			animalAge = "0～10代中";
		}

		return String.format("種類はウサギです。人間で言うと、%sです。", animalAge);
	}
}
