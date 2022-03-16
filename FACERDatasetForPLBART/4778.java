	public synchronized static void init(Context context) {
		if(NOTES.database==null) {
			NOTES.database=NOTES.new IndexerDbTable(context);
			//SortIndexerFiles();
		}
	}

