	public static final boolean isFragmentIdValid(short id) {
		for (int i = 0; i < listFragmentIds.length; i++) {
			if (listFragmentIds[i] == id) {
				return true;
			}
		}
		return false;
	}

