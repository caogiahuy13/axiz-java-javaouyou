package jp.co.axiz.app;

public abstract class GameApp implements App {
	private String item;
	private int playTime;

	public GameApp() {
		item = "";
	}

	public GameApp(String item) {
		this.item = item;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	protected abstract String play();

	@Override
	public String start(String name) {
		return String.format("%sさんと%sでゲームを開始します。", name, item) + this.play();
	}
}
