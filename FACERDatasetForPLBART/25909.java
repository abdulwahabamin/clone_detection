	/**
	 * <p>
	 * Gets a date/time formatter instance using the specified style, time zone
	 * and locale.
	 * </p>
	 * 
	 * @param dateStyle
	 *            date style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeStyle
	 *            time style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeZone
	 *            optional time zone, overrides time zone of formatted date
	 * @param locale
	 *            optional locale, overrides system locale
	 * @return a localized standard date/time formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no date/time pattern defined
	 */
	public static FastDateFormat getDateTimeInstance(int dateStyle,
                                                     int timeStyle, TimeZone timeZone, Locale locale) {
		return cache
				.getDateTimeInstance(dateStyle, timeStyle, timeZone, locale);
	}

