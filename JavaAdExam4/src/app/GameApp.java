package app;

public abstract class GameApp implements App {
	protected String item;

	public GameApp() {
		item = "";
	}

	public GameApp(String item) {
		this.item = item;
	}

	public abstract String play();

	@Override
	public String start(String name) {
		return String.format("%sさんと%sでゲームを開始します。", name, item) + this.play();
	}
}
