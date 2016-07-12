package scriptlib

class AHtmlUtils {
	// variation of HTMLUtils.java Replaces <p><\p> by <br>; for AButton formatted text
	public static String plainToHtmlForButton(final String text) {
		char myChar;
		final String textTabsExpanded = text.replaceAll("\t", "         ");
		final StringBuilder result = new StringBuilder(textTabsExpanded.length());
		final int lengthMinus1 = textTabsExpanded.length() - 1;
		result.append("<html><body>");	//result.append("<html><body><p>");
		for (int i = 0; i < textTabsExpanded.length(); ++i) {
			myChar = textTabsExpanded.charAt(i);
			switch (myChar) {
				case '&':
					result.append("&amp;");
					break;
				case '<':
					result.append("&lt;");
					break;
				case '>':
					result.append("&gt;");
					break;
				case ' ':
					if (i > 0 && i < lengthMinus1 && textTabsExpanded.charAt(i - 1) > 32
							&& textTabsExpanded.charAt(i + 1) > 32) {
						result.append(' ');
					}
					else {
						result.append("&nbsp;");
					}
					break;
				case '\n':
					result.append("<br>\n") //result.append("</p>\n<p>");
					break;
				default:
					result.append(myChar);
			}
		}
		result.append("</body></html>"); //result.append("</p></body></html>");
		return result.toString();
	}

}
