package jp.co.axiz.servlet;

import java.util.HashMap;

//todo: このクラスの処理は作成済。必要なクラスがそろえばコメントアウトを戻せば良い。
import jp.co.axiz.pet.Cat;
import jp.co.axiz.pet.Dog;
import jp.co.axiz.pet.Lizard;
import jp.co.axiz.pet.Pet;

/**
 * ペット情報の一覧をHashMapで保持しておくためのクラス
 */
public class PetSessionInfo {
	//todo: このクラスの処理は作成済。必要なクラスがそろえばコメントアウトを戻せば良い。
	private HashMap<String, Pet> petList;

	public PetSessionInfo() {
		petList = new HashMap<String, Pet>();

		Dog dog = new Dog("ポチ", 5, 55, 20, "柴犬", "代々木公園");
		Cat cat = new Cat("タマ", 3, 40, 4, "アメリカンショートヘア", "猫じゃらし");
		Lizard lizard = new Lizard("太郎", 36, 25, 1);

		petList.put("dog", dog);
		petList.put("cat", cat);
		petList.put("lizard", lizard);
	}

	/**
	 * ペット情報の一覧
	 */
	public void setPetList(HashMap<String, Pet> _petList) {
		petList = _petList;
	}

	/**
	 * ペット情報の一覧設定
	 */
	public HashMap<String, Pet> getPetList() {
		return petList;
	}
}
