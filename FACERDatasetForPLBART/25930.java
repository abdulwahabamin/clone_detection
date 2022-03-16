	/**
	 * <p>
	 * Returns a hashcode compatible with equals.
	 * </p>
	 * 
	 * @return a hashcode compatible with equals
	 */
	@Override
	public int hashCode() {
		return mPattern.hashCode() + 13
				* (mTimeZone.hashCode() + 13 * mLocale.hashCode());
	}

