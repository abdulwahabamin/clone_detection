	/**
	 * <p>
	 * Gets a date/time formatter instance using the specified style, time zone
	 * and locale.
	 * </p>
	 * 
	 * @param dateStyle
	 *            date style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeStyle
	 *            time style: FULL, LONG, MEDIUM, or SHORT
	 * @param timeZone
	 *            optional time zone, overrides time zone of formatted date
	 * @param locale
	 *            optional locale, overrides system locale
	 * @return a localized standard date/time formatter
	 * @throws IllegalArgumentException
	 *             if the Locale has no date/time pattern defined
	 */
	public F getDateTimeInstance(Integer dateStyle, Integer timeStyle,
                                 TimeZone timeZone, Locale locale) {
		if (locale == null) {
			locale = Locale.getDefault();
		}
		MultipartKey key = new MultipartKey(dateStyle, timeStyle, locale);

		String pattern = cDateTimeInstanceCache.get(key);
		if (pattern == null) {
			try {
				DateFormat formatter;
				if (dateStyle == null) {
					formatter = DateFormat.getTimeInstance(timeStyle, locale);
				} else if (timeStyle == null) {
					formatter = DateFormat.getDateInstance(dateStyle, locale);
				} else {
					formatter = DateFormat.getDateTimeInstance(dateStyle,
							timeStyle, locale);
				}
				pattern = ((SimpleDateFormat) formatter).toPattern();
				String previous = cDateTimeInstanceCache.putIfAbsent(key,
						pattern);
				if (previous != null) {
					// even though it doesn't matter if another thread put the
					// pattern
					// it's still good practice to return the String instance
					// that is
					// actually in the ConcurrentMap
					pattern = previous;
				}
			} catch (ClassCastException ex) {
				throw new IllegalArgumentException(
						"No date time pattern for locale: " + locale);
			}
		}

		return getInstance(pattern, timeZone, locale);
	}

