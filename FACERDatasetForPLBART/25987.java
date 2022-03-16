	/**
	 * <p>
	 * Gets a formatter instance using the specified pattern, time zone and
	 * locale.
	 * </p>
	 * 
	 * @param pattern
	 *            {@link SimpleDateFormat} compatible pattern
	 * @param timeZone
	 *            the non-null time zone
	 * @param locale
	 *            the non-null locale
	 * @return a pattern based date/time formatter
	 * @throws IllegalArgumentException
	 *             if pattern is invalid or <code>null</code>
	 */
	public F getInstance(String pattern, TimeZone timeZone, Locale locale) {
		if (pattern == null) {
			throw new NullPointerException("pattern must not be null");
		}
		if (timeZone == null) {
			timeZone = TimeZone.getDefault();
		}
		if (locale == null) {
			locale = Locale.getDefault();
		}
		MultipartKey key = new MultipartKey(pattern, timeZone, locale);
		F format = cInstanceCache.get(key);
		if (format == null) {
			format = createInstance(pattern, timeZone, locale);
			F previousValue = cInstanceCache.putIfAbsent(key, format);
			if (previousValue != null) {
				// another thread snuck in and did the same work
				// we should return the instance that is in ConcurrentMap
				format = previousValue;
			}
		}
		return format;
	}

