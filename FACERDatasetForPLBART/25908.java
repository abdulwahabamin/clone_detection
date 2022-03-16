	/**
	 * <p>
	 * Gets a date/time formatter instance using the specified style and time
	 * zone in the default locale.
	 * </p>
	 * 
	 * @param dateStyle
	 *            date style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeStyle
	 *            time style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeZone
	 *            optional time zone, overrides time zone of formatted date
	 * @return a localized standard date/time formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no date/time pattern defined
	 * @since 2.1
	 */
	public static FastDateFormat getDateTimeInstance(int dateStyle,
													 int timeStyle, TimeZone timeZone) {
		return getDateTimeInstance(dateStyle, timeStyle, timeZone, null);
	}

