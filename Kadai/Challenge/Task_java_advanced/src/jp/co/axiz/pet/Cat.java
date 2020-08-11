package jp.co.axiz.pet;

public class Cat extends Animal {
	String favoriteItem;

	public Cat() {

	}

	public Cat(String name, int age, int height, int weight, String type, String favoriteItem) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.type = type;
		this.favoriteItem = favoriteItem;
	}

	@Override
	public boolean isFat() {
		return (weight > 5) ? true : false;
	}

	public String getFavoriteItem() {
		return favoriteItem;
	}

	public void setFavoriteItem(String favoriteItem) {
		this.favoriteItem = favoriteItem;
	}

}
