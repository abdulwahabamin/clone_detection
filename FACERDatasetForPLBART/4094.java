	public long getObjectAsLong() {
		try {
			return ((Long) object).longValue();
		} catch(Exception e) {}
		return 0;
	}

