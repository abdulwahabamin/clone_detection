    /**
     * Deletes the specified library by its name and tag.
     */
    public void deleteLibrary(String libraryName, String tag) {
    	
    	//Escape any rogue apostrophes.
    	libraryName = libraryName.replace("'", "''");
    	tag = tag.replace("'", "''");
    	
    	//Perform the delete operation.
    	String where = LIBRARY_NAME + "=" + "'" + libraryName + "'" + " AND " 
    				 + LIBRARY_TAG + "=" + "'" + tag + "'";
    	
    	getDatabase().delete(LIBRARIES_TABLE, where, null);
    }

