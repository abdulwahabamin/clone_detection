	/**
	 * Converts from a boolean to a Last.fm boolean result string.
	 * 
	 * @param value A boolean value.
	 * @return A string representing a Last.fm boolean.
	 */
	public static String convertFromBoolean(boolean value) {
		if (value) {
			return "1";
		} else {
			return "0";
		}
	}

