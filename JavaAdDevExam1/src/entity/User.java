package entity;

/**
 * Userクラス
 */
public class User {

	// フィールド
	private String userId;
	private String userName;
	private int age;

	/**
	 * コンストラクタ(引数なし)
	 */
	public User() {
		userId = "";
		userName = "";
		age = 0;
	}

	/**
	 * コンストラクタ(引数3つ)
	 */
	public User(String userId, String userName, int age) {
		this.userId = userId;
		this.userName = userName;
		this.age = age;
	}

	/**
	 * ユーザー情報を取得するメソッド
	 */
	public String returnUserInfo() {
		return String.format("ユーザID:%s、ユーザ名:%s、年齢:%d", userId, userName, age);
	}

}
