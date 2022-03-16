	public double getObjectAsDouble() {
		try {
			return ((Double) object).intValue();
		} catch(Exception e) {}
		return 0;
	}

