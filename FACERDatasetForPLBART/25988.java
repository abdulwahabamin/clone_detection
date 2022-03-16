	/**
	 * <p>
	 * Create a format instance using the specified pattern, time zone and
	 * locale.
	 * </p>
	 *
	 * @param pattern
	 *            {@link SimpleDateFormat} compatible pattern, this
	 *            will not be null.
	 * @param timeZone
	 *            time zone, this will not be null.
	 * @param locale
	 *            locale, this will not be null.
	 * @return a pattern based date/time formatter
	 * @throws IllegalArgumentException
	 *             if pattern is invalid or <code>null</code>
	 */
	abstract protected F createInstance(String pattern, TimeZone timeZone,
                                        Locale locale);

