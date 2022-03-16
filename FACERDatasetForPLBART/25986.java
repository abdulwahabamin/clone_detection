	/**
	 * <p>
	 * Gets a formatter instance using the default pattern in the default
	 * timezone and locale.
	 * </p>
	 * 
	 * @return a date/time formatter
	 */
	public F getInstance() {
		return getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT,
				TimeZone.getDefault(), Locale.getDefault());
	}

