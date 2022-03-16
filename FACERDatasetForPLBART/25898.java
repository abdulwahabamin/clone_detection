	/**
	 * <p>
	 * Gets a date formatter instance using the specified style in the default
	 * time zone and locale.
	 * </p>
	 * 
	 * @param style
	 *            date style: FULL, LONG, MEDIUM, or SHORT
	 * @return a localized standard date formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no date pattern defined
	 * @since 2.1
	 */
	public static FastDateFormat getDateInstance(int style) {
		return cache.getDateTimeInstance(style, null, null, null);
	}

