	/**
	 * <p>
	 * Parsing is not supported.
	 * </p>
	 * 
	 * @param source
	 *            the string to parse
	 * @param pos
	 *            the parsing position
	 * @return {@code null} as not supported
	 */
	@Override
	public Object parseObject(String source, ParsePosition pos) {
		pos.setIndex(0);
		pos.setErrorIndex(0);
		return null;
	}

