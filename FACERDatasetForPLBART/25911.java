	/**
	 * <p>
	 * Constructs a new FastDateFormat.
	 * </p>
	 * 
	 * @param pattern
	 *            {@link java.text.SimpleDateFormat} compatible pattern
	 * @param timeZone
	 *            non-null time zone to use
	 * @param locale
	 *            non-null locale to use
	 * @throws NullPointerException
	 *             if pattern, timeZone, or locale is null.
	 */
	protected FastDateFormat(String pattern, TimeZone timeZone, Locale locale) {
		mPattern = pattern;
		mTimeZone = timeZone;
		mLocale = locale;

		init();
	}

