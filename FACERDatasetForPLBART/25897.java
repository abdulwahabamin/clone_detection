	/**
	 * <p>
	 * Gets a formatter instance using the specified pattern, time zone and
	 * locale.
	 * </p>
	 * 
	 * @param pattern
	 *            {@link java.text.SimpleDateFormat} compatible pattern
	 * @param timeZone
	 *            optional time zone, overrides time zone of formatted date
	 * @param locale
	 *            optional locale, overrides system locale
	 * @return a pattern based date/time formatter
	 * @throws IllegalArgumentException
	 *             if pattern is invalid or {@code null}
	 */
	public static FastDateFormat getInstance(String pattern, TimeZone timeZone,
                                             Locale locale) {
		return cache.getInstance(pattern, timeZone, locale);
	}

