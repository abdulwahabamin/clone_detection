	/**
	 * Returns a singleton instance for the database. 
	 * @param context
	 * @return
	 */
	public static synchronized DBAccessHelper getInstance(Context context) {
	    if (sInstance==null)
	    	sInstance = new DBAccessHelper(context.getApplicationContext());
	    
	    return sInstance;
	}

