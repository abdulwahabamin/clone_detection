	/**
	 * Constructs the selection string for limiting the MediaStore 
	 * query to specific music folders.
	 */
	private String buildMusicFoldersSelection(Cursor musicFoldersCursor) {
		String mediaStoreSelection = MediaStore.Audio.Media.IS_MUSIC + "!=0 AND (";
        int folderPathColIndex = musicFoldersCursor.getColumnIndex(DBAccessHelper.FOLDER_PATH);
        int includeColIndex = musicFoldersCursor.getColumnIndex(DBAccessHelper.INCLUDE);
        
        for (int i=0; i < musicFoldersCursor.getCount(); i++) {
        	musicFoldersCursor.moveToPosition(i);
        	boolean include = musicFoldersCursor.getInt(includeColIndex) > 0;
        	
        	//Set the correct LIKE clause.
        	String likeClause;
        	if (include)
        		likeClause = " LIKE ";
        	else
        		likeClause = " NOT LIKE ";
        	
        	//The first " AND " clause was already appended to mediaStoreSelection.
        	if (i!=0 && !include)
        		mediaStoreSelection += " AND ";
        	else if (i!=0 && include)
        		mediaStoreSelection += " OR ";
        	
        	mediaStoreSelection += MediaStore.Audio.Media.DATA + likeClause
								+ "'%" + musicFoldersCursor.getString(folderPathColIndex) 
								+ "/%'";

        }
        
        //Append the closing parentheses.
        mediaStoreSelection += ")";
        return mediaStoreSelection;
	}

