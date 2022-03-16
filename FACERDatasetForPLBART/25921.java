	/**
	 * <p>
	 * Formats a {@code Date} object into the supplied {@code StringBuffer}
	 * using a {@code GregorianCalendar}.
	 * </p>
	 * 
	 * @param date
	 *            the date to format
	 * @param buf
	 *            the buffer to format into
	 * @return the specified string buffer
	 */
	public StringBuffer format(Date date, StringBuffer buf) {
		Calendar c = new GregorianCalendar(mTimeZone, mLocale); // hard code
																// GregorianCalendar
		c.setTime(date);
		return applyRules(c, buf);
	}

