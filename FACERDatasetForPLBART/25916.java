	/**
	 * <p>
	 * Formats a {@code Date}, {@code Calendar} or {@code Long} (milliseconds)
	 * object.
	 * </p>
	 * 
	 * @param obj
	 *            the object to format
	 * @param toAppendTo
	 *            the buffer to append to
	 * @param pos
	 *            the position - ignored
	 * @return the buffer passed in
	 */
	@Override
	public StringBuffer format(Object obj, StringBuffer toAppendTo,
                               FieldPosition pos) {
		if (obj instanceof Date) {
			return format((Date) obj, toAppendTo);
		} else if (obj instanceof Calendar) {
			return format((Calendar) obj, toAppendTo);
		} else if (obj instanceof Long) {
			return format(((Long) obj).longValue(), toAppendTo);
		} else {
			throw new IllegalArgumentException("Unknown class: "
					+ (obj == null ? "<null>" : obj.getClass().getName()));
		}
	}

