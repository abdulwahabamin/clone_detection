	/**
	 * <p>
	 * Formats a {@code Calendar} object into the supplied {@code StringBuffer}.
	 * </p>
	 * 
	 * @param calendar
	 *            the calendar to format
	 * @param buf
	 *            the buffer to format into
	 * @return the specified string buffer
	 */
	public StringBuffer format(Calendar calendar, StringBuffer buf) {
		return applyRules(calendar, buf);
	}

