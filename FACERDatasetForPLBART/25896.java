	/**
	 * <p>
	 * Gets a formatter instance using the specified pattern and locale.
	 * </p>
	 * 
	 * @param pattern
	 *            {@link java.text.SimpleDateFormat} compatible pattern
	 * @param locale
	 *            optional locale, overrides system locale
	 * @return a pattern based date/time formatter
	 * @throws IllegalArgumentException
	 *             if pattern is invalid
	 */
	public static FastDateFormat getInstance(String pattern, Locale locale) {
		return cache.getInstance(pattern, null, locale);
	}

