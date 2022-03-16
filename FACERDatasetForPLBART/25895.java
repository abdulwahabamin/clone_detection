	/**
	 * <p>
	 * Gets a formatter instance using the specified pattern and time zone.
	 * </p>
	 * 
	 * @param pattern
	 *            {@link java.text.SimpleDateFormat} compatible pattern
	 * @param timeZone
	 *            optional time zone, overrides time zone of formatted date
	 * @return a pattern based date/time formatter
	 * @throws IllegalArgumentException
	 *             if pattern is invalid
	 */
	public static FastDateFormat getInstance(String pattern, TimeZone timeZone) {
		return cache.getInstance(pattern, timeZone, null);
	}

