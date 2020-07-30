package app;

public class GameApp {
	protected String item;

	public GameApp() {
		item = "";
	}

	public GameApp(String item) {
		this.item = item;
	}

	public String start(String name) {
		return String.format("%sさんと%sでゲームを開始します", name, item);
	}
}
