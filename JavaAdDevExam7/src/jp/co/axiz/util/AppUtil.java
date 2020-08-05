package jp.co.axiz.util;

import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.app.GameApp;

public class AppUtil {
	public static boolean isGameApp(App app) {
		return (app instanceof GameApp) ? true : false;
	}

	public static boolean isCardGameApp(App app) {
		return (app instanceof CardGameApp) ? true : false;
	}

	public static boolean isDartsGameApp(App app) {
		return (app instanceof DartsGameApp) ? true : false;
	}

	public static boolean isClockApp(App app) {
		return (app instanceof ClockApp) ? true : false;
	}

	public static String getAppName(App app) {
		if (app instanceof CardGameApp) {
			return "ゲーム:カード";
		} else if (app instanceof DartsGameApp) {
			return "ゲーム:ダーツ";
		} else {
			return "時計";
		}

	}
}
