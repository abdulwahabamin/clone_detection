	/**
	 * <p>
	 * Gets a date/time formatter instance using the specified style and locale
	 * in the default time zone.
	 * </p>
	 * 
	 * @param dateStyle
	 *            date style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeStyle
	 *            time style: FULL, LONG, MEDIUM, or SHORT
	 * @param locale
	 *            optional locale, overrides system locale
	 * @return a localized standard date/time formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no date/time pattern defined
	 * @since 2.1
	 */
	public static FastDateFormat getDateTimeInstance(int dateStyle,
													 int timeStyle, Locale locale) {
		return cache.getDateTimeInstance(dateStyle, timeStyle, null, locale);
	}

