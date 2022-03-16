	/**
	 * <p>
	 * Gets a time formatter instance using the specified style and locale in
	 * the default time zone.
	 * </p>
	 * 
	 * @param style
	 *            time style: FULL, LONG, MEDIUM, or SHORT
	 * @param locale
	 *            optional locale, overrides system locale
	 * @return a localized standard time formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no time pattern defined
	 * @since 2.1
	 */
	public static FastDateFormat getTimeInstance(int style, Locale locale) {
		return cache.getDateTimeInstance(null, style, null, locale);
	}

