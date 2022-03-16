	/**
	 * <p>
	 * Gets a time formatter instance using the specified style and time zone in
	 * the default locale.
	 * </p>
	 * 
	 * @param style
	 *            time style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeZone
	 *            optional time zone, overrides time zone of formatted time
	 * @return a localized standard time formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no time pattern defined
	 * @since 2.1
	 */
	public static FastDateFormat getTimeInstance(int style, TimeZone timeZone) {
		return cache.getDateTimeInstance(null, style, timeZone, null);
	}

