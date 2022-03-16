	/**
	 * Converts a Last.fm boolean result string to a boolean.
	 *
	 * @param resultString A Last.fm boolean result string.
	 * @return <code>true</code> if the given String represents a true, <code>false</code> otherwise.
	 */
	public static boolean convertToBoolean(String resultString) {
		return "1".equals(resultString);
	}

