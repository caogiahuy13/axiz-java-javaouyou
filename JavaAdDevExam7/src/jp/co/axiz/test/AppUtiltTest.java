package jp.co.axiz.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.util.AppUtil;

class AppUtiltTest {

	/**
	 * isGameApp Unit Test
	 */
	@Test
	public void isGameApp_1_ShouldReturnTrue_WhenAppIsCardGameApp() {
		App app = new CardGameApp();

		boolean actual = AppUtil.isGameApp(app);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void isGameApp_2_ShouldReturnTrue_WhenAppIsDartsGameApp() {
		App app = new DartsGameApp();

		boolean actual = AppUtil.isGameApp(app);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void isGameApp_3_ShouldReturnTrue_WhenAppIsClockApp() {
		App app = new ClockApp();

		boolean actual = AppUtil.isGameApp(app);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	/**
	 * isCardGameApp Unit Test
	 */
	@Test
	public void isCardGameApp_1_ShouldReturnTrue_WhenAppIsCardGameApp() {
		App app = new CardGameApp();

		boolean actual = AppUtil.isCardGameApp(app);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void isCardGameApp_2_ShouldReturnFalse_WhenAppIsDartsGameApp() {
		App app = new DartsGameApp();

		boolean actual = AppUtil.isCardGameApp(app);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void isCardGameApp_3_ShouldReturnFalse_WhenAppIsClockApp() {
		App app = new ClockApp();

		boolean actual = AppUtil.isCardGameApp(app);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	/**
	 * isDartsGameApp Unit Test
	 */
	@Test
	public void isDartsGameAppp_1_ShouldReturnFalse_WhenAppIsCardGameApp() {
		App app = new CardGameApp();

		boolean actual = AppUtil.isDartsGameApp(app);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void isDartsGameAppp_2_ShouldReturnTrue_WhenAppIsDartsGameApp() {
		App app = new DartsGameApp();

		boolean actual = AppUtil.isDartsGameApp(app);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void isDartsGameAppp_3_ShouldReturnFalse_WhenAppIsClockApp() {
		App app = new ClockApp();

		boolean actual = AppUtil.isDartsGameApp(app);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	/**
	 * isClockApp Unit Test
	 */
	@Test
	public void isClockApp_1_ShouldReturnFalse_WhenAppIsCardGameApp() {
		App app = new CardGameApp();

		boolean actual = AppUtil.isClockApp(app);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void isClockApp_2_ShouldReturnFalse_WhenAppIsClockApp() {
		App app = new DartsGameApp();

		boolean actual = AppUtil.isClockApp(app);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void isClockApp_3_ShouldReturnTrue_WhenAppIsClockApp() {
		App app = new ClockApp();

		boolean actual = AppUtil.isClockApp(app);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	/**
	 * getAppName Unit Test
	 */
	@Test
	public void getAppName_1_ShouldReturnCardGameAppName_WhenAppIsCardGameApp() {
		App app = new CardGameApp();

		String actual = AppUtil.getAppName(app);
		String expected = "ゲーム:カード";

		assertEquals(expected, actual);
	}

	@Test
	public void getAppName_2_ShouldReturnDartsGameAppName_WhenAppIsDartsGameApp() {
		App app = new DartsGameApp();

		String actual = AppUtil.getAppName(app);
		String expected = "ゲーム:ダーツ";

		assertEquals(expected, actual);
	}

	@Test
	public void getAppName_3_ShouldReturnClockGameAppName_WhenAppIsClockApp() {
		App app = new ClockApp();

		String actual = AppUtil.getAppName(app);
		String expected = "時計";

		assertEquals(expected, actual);
	}
}
