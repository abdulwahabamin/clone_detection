	public synchronized static boolean remove(IndexerFile item) {
		if(item!=null) {
			NOTES.database.delete(item);
			return true;
		} else 
			return false;
		
	}

