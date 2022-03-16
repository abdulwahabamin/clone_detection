	/**
	 * Tests if the given string <i>might</i> already be a 32-char md5 string.
	 *
	 * @param s String to test
	 * @return <code>true</code> if the given String might be a md5 string
	 */
	public static boolean isMD5(String s) {
		return s.length() == 32 && MD5_PATTERN.matcher(s).matches();
	}

