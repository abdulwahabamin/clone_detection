	/**
	 * Retrieves a cursor of songs from MediaStore. The cursor 
	 * is limited to songs that are within the folders that the user 
	 * selected.
	 */
	private Cursor getSongsFromMediaStore() {
		//Get a cursor of all active music folders.
        Cursor musicFoldersCursor = mApp.getDBAccessHelper().getAllMusicFolderPaths();
        
        //Build the appropriate selection statement.
        Cursor mediaStoreCursor = null;
        String sortOrder = null;
        String projection[] = { MediaStore.Audio.Media.TITLE, 
        						MediaStore.Audio.Media.ARTIST,
        						MediaStore.Audio.Media.ALBUM, 
        						MediaStore.Audio.Media.ALBUM_ID,
        						MediaStore.Audio.Media.DURATION, 
        						MediaStore.Audio.Media.TRACK, 
        						MediaStore.Audio.Media.YEAR, 
        						MediaStore.Audio.Media.DATA, 
        						MediaStore.Audio.Media.DATE_ADDED, 
        						MediaStore.Audio.Media.DATE_MODIFIED, 
        						MediaStore.Audio.Media._ID,
        						MediaStoreAccessHelper.ALBUM_ARTIST };
        
        //Grab the cursor of MediaStore entries.
        if (musicFoldersCursor==null || musicFoldersCursor.getCount() < 1) {
        	//No folders were selected by the user. Grab all songs in MediaStore.
        	mediaStoreCursor = MediaStoreAccessHelper.getAllSongs(mContext, projection, sortOrder);
        } else {
        	//Build a selection statement for querying MediaStore.
            mMediaStoreSelection = buildMusicFoldersSelection(musicFoldersCursor);
            mediaStoreCursor = MediaStoreAccessHelper.getAllSongsWithSelection(mContext, 
            																   mMediaStoreSelection, 
            																   projection, 
            																   sortOrder);

            //Close the music folders cursor.
            musicFoldersCursor.close(); 
        }

    	return mediaStoreCursor;
	}

