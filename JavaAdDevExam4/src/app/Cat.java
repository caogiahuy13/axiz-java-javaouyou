package app;

public class Cat extends Animal {
	public Cat() {

	}

	public Cat(String name, int age) {
		super(name, age);
	}

	@Override
	public String introduceAge() {
		String animalAge = "";

		if (age > 10) {
			animalAge = "60歳以上";
		} else if (age > 9) {
			animalAge = "50代";
		} else if (age > 6) {
			animalAge = "40代";
		} else if (age > 4) {
			animalAge = "30代";
		} else if (age > 2) {
			animalAge = "20代";
		} else if (age == 1) {
			animalAge = "10代中";
		} else {
			animalAge = "0～10代中";
		}

		return String.format("種類はネコです。人間で言うと、%sです。", animalAge);
	}
}
