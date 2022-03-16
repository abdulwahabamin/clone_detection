	/**
	 * <p>
	 * Gets a formatter instance using the specified pattern in the default
	 * locale.
	 * </p>
	 * 
	 * @param pattern
	 *            {@link java.text.SimpleDateFormat} compatible pattern
	 * @return a pattern based date/time formatter
	 * @throws IllegalArgumentException
	 *             if pattern is invalid
	 */
	public static FastDateFormat getInstance(String pattern) {
		return cache.getInstance(pattern, null, null);
	}

