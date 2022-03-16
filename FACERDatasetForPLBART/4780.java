	public synchronized static long add(IndexerFile item) {
		if(item!=null) {
			long id=NOTES.database.add(item);
			return id;
		}
		return -1;
	}

