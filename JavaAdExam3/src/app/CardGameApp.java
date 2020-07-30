package app;

public class CardGameApp extends GameApp {
	public CardGameApp() {
		super();
	}

	public CardGameApp(String item) {
		super(item);
	}

	@Override
	public String start(String name) {
		return String.format("%sさんと%sでゲームを開始します。ババ抜きを行います。", name, item);
	}
}
