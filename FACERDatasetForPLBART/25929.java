	/**
	 * <p>
	 * Compares two objects for equality.
	 * </p>
	 * 
	 * @param obj
	 *            the object to compare to
	 * @return {@code true} if equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FastDateFormat == false) {
			return false;
		}
		FastDateFormat other = (FastDateFormat) obj;
		return mPattern.equals(other.mPattern)
				&& mTimeZone.equals(other.mTimeZone)
				&& mLocale.equals(other.mLocale);
	}

