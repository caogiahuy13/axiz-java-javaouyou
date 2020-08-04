package servlet;

/**
 * Utilityメソッドをまとめたクラス
 */
public class Utility {

	/**
	 * 引数に指定した文字列がnull、または空文字かを判定
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		// このメソッドは作成済
		if (str == null || str.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
