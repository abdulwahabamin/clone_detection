	/**
	 * <p>
	 * Gets a date formatter instance using the specified style, time zone and
	 * locale.
	 * </p>
	 * 
	 * @param style
	 *            date style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeZone
	 *            optional time zone, overrides time zone of formatted date
	 * @param locale
	 *            optional locale, overrides system locale
	 * @return a localized standard date formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no date pattern defined
	 */
	public static FastDateFormat getDateInstance(int style, TimeZone timeZone,
												 Locale locale) {
		return cache.getDateTimeInstance(style, null, timeZone, locale);
	}

