	/**
	 * <p>
	 * Gets a time formatter instance using the specified style, time zone and
	 * locale.
	 * </p>
	 * 
	 * @param style
	 *            time style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeZone
	 *            optional time zone, overrides time zone of formatted time
	 * @param locale
	 *            optional locale, overrides system locale
	 * @return a localized standard time formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no time pattern defined
	 */
	public static FastDateFormat getTimeInstance(int style, TimeZone timeZone,
												 Locale locale) {
		return cache.getDateTimeInstance(null, style, timeZone, locale);
	}

