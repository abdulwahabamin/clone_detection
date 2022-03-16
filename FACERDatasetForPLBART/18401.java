	@Override
	protected void finalize() {
		try {
			getDatabase().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

