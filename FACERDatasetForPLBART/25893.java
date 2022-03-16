	/**
	 * <p>
	 * Gets a formatter instance using the default pattern in the default
	 * locale.
	 * </p>
	 * 
	 * @return a date/time formatter
	 */
	public static FastDateFormat getInstance() {
		return cache.getDateTimeInstance(SHORT, SHORT, null, null);
	}

