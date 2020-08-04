package servlet;

import java.util.HashMap;

/**
 * 辞書情報を管理するためのクラス
 */
public class Dictionary {

    /**
     * 辞書情報を表すHashMap (Key：英語、Value：日本語)
     */
    public static HashMap<String, String> dictionary = new HashMap<String, String>();
}
