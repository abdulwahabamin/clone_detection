	/**
	 * <p>
	 * Formats a milliseond {@code long} value into the supplied
	 * {@code StringBuffer}.
	 * </p>
	 * 
	 * @param millis
	 *            the millisecond value to format
	 * @param buf
	 *            the buffer to format into
	 * @return the specified string buffer
	 * @since 2.1
	 */
	public StringBuffer format(long millis, StringBuffer buf) {
		return format(new Date(millis), buf);
	}

