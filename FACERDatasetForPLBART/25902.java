	/**
	 * <p>
	 * Gets a time formatter instance using the specified style in the default
	 * time zone and locale.
	 * </p>
	 * 
	 * @param style
	 *            time style: FULL, LONG, MEDIUM, or SHORT
	 * @return a localized standard time formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no time pattern defined
	 * @since 2.1
	 */
	public static FastDateFormat getTimeInstance(int style) {
		return cache.getDateTimeInstance(null, style, null, null);
	}

