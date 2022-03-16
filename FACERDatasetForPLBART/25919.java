	/**
	 * <p>
	 * Formats a {@code Calendar} object.
	 * </p>
	 * 
	 * @param calendar
	 *            the calendar to format
	 * @return the formatted string
	 */
	public String format(Calendar calendar) {
		return format(calendar, new StringBuffer(mMaxLengthEstimate))
				.toString();
	}

