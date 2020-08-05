package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParamUtilTest {
	/**
	 * isNullOrEmpty Unit Test
	 */
	@Test
	public void isNullOrEmpty_1_ShouldReturnFalse_WhenStringIsNotNullOrEmpty() {
		String str = "a";

		boolean actual = ParamUtil.isNullOrEmpty(str);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void isNullOrEmpty_2_ShouldReturnTrue_WhenStringIsEmpty_2() {
		String str = "";

		boolean actual = ParamUtil.isNullOrEmpty(str);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void isNullOrEmpty_3_ShouldReturnTrue_WhenStringIsNull_3() {
		String str = null;

		boolean actual = ParamUtil.isNullOrEmpty(str);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	/**
	 * isNumber Unit Test
	 */
	@Test
	public void isNumber_1_ShouldReturnFalse_WhenNumberIsOverNegativeLimit() {
		String str = "-2147483649";

		boolean actual = ParamUtil.isNumber(str);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void isNumber_2_ShouldReturnTrue_WhenNumberIsMaxNegativeValue() {
		String str = "-2147483648";

		boolean actual = ParamUtil.isNumber(str);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void isNumber_3_ShouldReturnTrue_WhenNumberIsZero() {
		String str = "0";

		boolean actual = ParamUtil.isNumber(str);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void isNumber_4_ShouldReturnTrue_WhenNumberIsMaxPositiveValue() {
		String str = "2147483647";

		boolean actual = ParamUtil.isNumber(str);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void isNumber_5_ShouldReturnFalse_WhenNumberIsOverPositiveLimit() {
		String str = "2147483648";

		boolean actual = ParamUtil.isNumber(str);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void isNumber_6_ShouldReturnFalse_WhenStringIsNull() {
		String str = null;

		boolean actual = ParamUtil.isNumber(str);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void isNumber_7_ShouldReturnFalse_WhenStringIsEmpty() {
		String str = "";

		boolean actual = ParamUtil.isNumber(str);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void isNumber_8_ShouldReturnFalse_WhenStringIsACharacter() {
		String str = "a";

		boolean actual = ParamUtil.isNumber(str);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	@Test
	public void isNumber_9_ShouldReturnTrue_WhenStringIsANumber() {
		String str = "1";

		boolean actual = ParamUtil.isNumber(str);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	@Test
	public void isNumber_10_ShouldReturnFalse_WhenStringIsAKanjiCharacter() {
		String str = "あ";

		boolean actual = ParamUtil.isNumber(str);
		boolean expected = false;

		assertEquals(expected, actual);
	}

	/**
	 * checkAndParseInt Unit Test
	 */
	@Test
	public void checkAndParseInt_1_ShouldReturnNull_WhenNumberIsOverNegativeLimit() {
		String str = "-2147483649";

		Integer actual = ParamUtil.checkAndParseInt(str);
		Integer expected = null;

		assertEquals(expected, actual);
	}

	@Test
	public void checkAndParseInt_2_ShouldReturnMaxNegativeValue_WhenNumberIsMaxNegativeValue() {
		String str = "-2147483648";

		Integer actual = ParamUtil.checkAndParseInt(str);
		Integer expected = -2147483648;

		assertEquals(expected, actual);
	}

	@Test
	public void checkAndParseInt_3_ShouldReturnZero_WhenNumberIsZero() {
		String str = "0";

		Integer actual = ParamUtil.checkAndParseInt(str);
		Integer expected = 0;

		assertEquals(expected, actual);
	}

	@Test
	public void checkAndParseInt_4_ShouldReturnMaxPositiveValue_WhenNumberIsMaxPositiveValue() {
		String str = "2147483647";

		Integer actual = ParamUtil.checkAndParseInt(str);
		Integer expected = 2147483647;

		assertEquals(expected, actual);
	}

	@Test
	public void checkAndParseInt_5_ShouldReturnNull_WhenNumberIsOverPositiveLimit() {
		String str = "2147483648";

		Integer actual = ParamUtil.checkAndParseInt(str);
		Integer expected = null;

		assertEquals(expected, actual);
	}

	@Test
	public void checkAndParseInt_6_ShouldReturnNull_WhenStringIsNull() {
		String str = null;

		Integer actual = ParamUtil.checkAndParseInt(str);
		Integer expected = null;

		assertEquals(expected, actual);
	}

	@Test
	public void checkAndParseInt_7_ShouldReturnNull_WhenStringIsEmpty() {
		String str = "";

		Integer actual = ParamUtil.checkAndParseInt(str);
		Integer expected = null;

		assertEquals(expected, actual);
	}

	@Test
	public void checkAndParseInt_8_ShouldReturnNull_WhenStringIsACharacter() {
		String str = "a";

		Integer actual = ParamUtil.checkAndParseInt(str);
		Integer expected = null;

		assertEquals(expected, actual);
	}

	@Test
	public void checkAndParseInt_9_ShouldReturnNumber_WhenStringIsANumber() {
		String str = "1";

		Integer actual = ParamUtil.checkAndParseInt(str);
		Integer expected = 1;

		assertEquals(expected, actual);
	}

	@Test
	public void checkAndParseInt_10_ShouldReturnNull_WhenStringIsAKanjiCharacter() {
		String str = "あ";

		Integer actual = ParamUtil.checkAndParseInt(str);
		Integer expected = null;

		assertEquals(expected, actual);
	}

}
