    /** 
     * Returns a cursor with a list of all unique libraries within the database.
     * @return
     */
    public Cursor getAllUniqueLibraries() {
    	String rawQuery = "SELECT DISTINCT(" + LIBRARY_NAME + "), " + 
						  _ID + ", " + LIBRARY_TAG +
						  " FROM " + LIBRARIES_TABLE + " GROUP BY " + 
						  LIBRARY_NAME + " ORDER BY " + _ID
						  + " ASC";
    	
    	Cursor cursor = getDatabase().rawQuery(rawQuery, null);
    	return cursor;
    }

