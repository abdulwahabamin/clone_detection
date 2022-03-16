	/**
	 * <p>
	 * Formats a millisecond {@code long} value.
	 * </p>
	 * 
	 * @param millis
	 *            the millisecond value to format
	 * @return the formatted string
	 * @since 2.1
	 */
	public String format(long millis) {
		return format(new Date(millis));
	}

