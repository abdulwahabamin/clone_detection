	/**
	 * Returns a writable instance of the database. Provides an additional 
	 * null check for additional stability.
	 */
	private synchronized SQLiteDatabase getDatabase() {
		if (mDatabase==null)
			mDatabase = getWritableDatabase();

		return mDatabase;
	}

