	/**
	 * <p>
	 * Performs the formatting by applying the rules to the specified calendar.
	 * </p>
	 * 
	 * @param calendar
	 *            the calendar to format
	 * @param buf
	 *            the buffer to format into
	 * @return the specified string buffer
	 */
	protected StringBuffer applyRules(Calendar calendar, StringBuffer buf) {
		for (Rule rule : mRules) {
			rule.appendTo(buf, calendar);
		}
		return buf;
	}

