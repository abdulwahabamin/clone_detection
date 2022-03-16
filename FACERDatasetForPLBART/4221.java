	public static IndexerFile get(int index) {
		if(index>=0 && index<results.size()) {
			return results.get(index);
		}
		return null;
	}

