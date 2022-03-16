	/**
	 * <p>
	 * Gets a date formatter instance using the specified style and time zone in
	 * the default locale.
	 * </p>
	 * 
	 * @param style
	 *            date style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeZone
	 *            optional time zone, overrides time zone of formatted date
	 * @return a localized standard date formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no date pattern defined
	 * @since 2.1
	 */
	public static FastDateFormat getDateInstance(int style, TimeZone timeZone) {
		return cache.getDateTimeInstance(style, null, timeZone, null);
	}

