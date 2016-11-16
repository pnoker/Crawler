package com.util;
/**
 * @author Pnoker
 *
 */
public class StringFormat {
	/**
	 * 全角转半角
	 * 
	 * 全角格式：ｈｅｌｌｏｗ ｗｏｒｌｄ -> 半角格式：hellow world
	 */
	public String ToDBC(String input) {

		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '\u3000') {
				c[i] = ' ';
			} else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
				c[i] = (char) (c[i] - 65248);

			}
		}
		String returnString = new String(c);

		return returnString;
	}

	/**
	 * 半角转全角
	 * 
	 * 半角格式：hellow world -> 全角格式：ｈｅｌｌｏｗ ｗｏｒｌｄ
	 */
	public String ToSBC(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c[i] = '\u3000';
			} else if (c[i] < '\177') {
				c[i] = (char) (c[i] + 65248);

			}
		}
		return new String(c);
	}
}
