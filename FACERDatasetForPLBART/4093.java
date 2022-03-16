	public int getObjectAsInt() {
		try {
			return ((Integer) object).intValue();
		} catch(Exception e) {}
		return 0;
	}

