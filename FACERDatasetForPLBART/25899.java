	/**
	 * <p>
	 * Gets a date formatter instance using the specified style and locale in
	 * the default time zone.
	 * </p>
	 * 
	 * @param style
	 *            date style: FULL, LONG, MEDIUM, or SHORT
	 * @param locale
	 *            optional locale, overrides system locale
	 * @return a localized standard date formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no date pattern defined
	 * @since 2.1
	 */
	public static FastDateFormat getDateInstance(int style, Locale locale) {
		return cache.getDateTimeInstance(style, null, null, locale);
	}

