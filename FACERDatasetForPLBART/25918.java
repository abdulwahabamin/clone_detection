	/**
	 * <p>
	 * Formats a {@code Date} object using a {@code GregorianCalendar}.
	 * </p>
	 * 
	 * @param date
	 *            the date to format
	 * @return the formatted string
	 */
	public String format(Date date) {
		Calendar c = new GregorianCalendar(mTimeZone, mLocale); // hard code
																// GregorianCalendar
		c.setTime(date);
		return applyRules(c, new StringBuffer(mMaxLengthEstimate)).toString();
	}

