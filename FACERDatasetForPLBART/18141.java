    private void assignCursor() {
    	
    	DBAccessHelper dbHelper = new DBAccessHelper(mContext);
    	
    	if (mEnqueueType.equals("SONG")) {
    		String selection = null;
    		if (mApp.isGooglePlayMusicEnabled()) {
    			selection = DBAccessHelper.SONG_ARTIST + "=" + "'" + mArtistName + "'" + " AND "
    					  + DBAccessHelper.SONG_ALBUM + "=" + "'" + mAlbumName + "'" + " AND "
    					  + DBAccessHelper.SONG_TITLE + "=" + "'" + mSongTitle + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
    		} else {
    			selection = DBAccessHelper.SONG_ARTIST + "=" + "'" + mArtistName + "'" + " AND "
  					  	  + DBAccessHelper.SONG_ALBUM + "=" + "'" + mAlbumName + "'" + " AND "
  					  	  + DBAccessHelper.SONG_TITLE + "=" + "'" + mSongTitle + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'" + " AND "
  					  	  + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
    		}

    		mCursor = dbHelper.getReadableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
   													   	   null, 
   													   	   selection, 
   													   	   null, 
   													   	   null, 
   													   	   null, 
   													   	   DBAccessHelper.SONG_TITLE + " ASC");
    		
    		mPlayingNext = mSongTitle;
    	} else if (mEnqueueType.equals("ARTIST")) {
    		String selection = null;
    		if (mApp.isGooglePlayMusicEnabled()) {
    			selection = DBAccessHelper.SONG_ARTIST + "=" + "'" + mArtistName + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
    		} else {
    			selection = DBAccessHelper.SONG_ARTIST + "=" + "'" + mArtistName + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'" + " AND "
  					  	  + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
    		}
    		
    		mCursor = dbHelper.getReadableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
    													   null, 
    													   selection, 
    													   null, 
    													   null, 
    													   null, 
    													   DBAccessHelper.SONG_ALBUM + " ASC" + ", " + DBAccessHelper.SONG_TRACK_NUMBER + "*1 ASC");	
    		
    		mPlayingNext = mArtistName;
    	} else if (mEnqueueType.equals("ALBUM")) {
    		
    		String selection = null;
    		if (mApp.isGooglePlayMusicEnabled()) {
    			selection = DBAccessHelper.SONG_ARTIST + "=" + "'" + mArtistName + "'" + " AND "
    					  + DBAccessHelper.SONG_ALBUM + "=" + "'" + mAlbumName + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
    		} else {
    			selection = DBAccessHelper.SONG_ARTIST + "=" + "'" + mArtistName + "'" + " AND "
  					  	  + DBAccessHelper.SONG_ALBUM + "=" + "'" + mAlbumName + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'" + " AND "
  					  	  + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
    		}
    		
    		mCursor = dbHelper.getReadableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
														   null, 
														   selection, 
														   null, 
														   null, 
														   null, 
														   DBAccessHelper.SONG_TRACK_NUMBER + "*1 ASC");
    		
    		mPlayingNext = mAlbumName;
    	} else if (mEnqueueType.equals("ALBUM_BY_ALBUM_ARTIST")) { 
    		String selection = null;
    		if (mApp.isGooglePlayMusicEnabled()) {
    			selection = DBAccessHelper.SONG_ALBUM_ARTIST + "=" + "'" + mAlbumArtistName + "'" + " AND "
    					  + DBAccessHelper.SONG_ALBUM + "=" + "'" + mAlbumName + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
    		} else {
    			selection = DBAccessHelper.SONG_ALBUM_ARTIST + "=" + "'" + mAlbumArtistName + "'" + " AND "
    					  + DBAccessHelper.SONG_ALBUM + "=" + "'" + mAlbumName + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'" + " AND "
  					  	  + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
    		}
    		
    		mCursor = dbHelper.getReadableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
														   null, 
														   selection, 
														   null, 
														   null, 
														   null, 
														   DBAccessHelper.SONG_TRACK_NUMBER + "*1 ASC");
    		
    		mPlayingNext = mAlbumName;
    	} else if (mEnqueueType.equals("ALBUM_ARTIST")) {
    		String selection = null;
    		if (mApp.isGooglePlayMusicEnabled()) {
    			selection = DBAccessHelper.SONG_ALBUM_ARTIST + "=" + "'" + mAlbumArtistName + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
    		} else {
    			selection = DBAccessHelper.SONG_ALBUM_ARTIST + "=" + "'" + mAlbumArtistName + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'" + " AND "
  					  	  + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
    		}
    		
    		mCursor = dbHelper.getReadableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
														   null, 
														   selection, 
														   null, 
														   null, 
														   null, 
														   DBAccessHelper.SONG_ALBUM + " ASC, " + DBAccessHelper.SONG_TRACK_NUMBER + "*1 ASC");
    	
    		mPlayingNext = mAlbumArtistName;
    	} else if (mEnqueueType.equals("TOP_25_PLAYED")) {
    		
    		String selection = null;
            if (mApp.isGooglePlayMusicEnabled()==false) {
            	selection = DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'" + " AND "
            			  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
            } else {
            	selection = DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
            }
            
            mCursor = dbHelper.getTop25PlayedTracks(selection);
            mPlayingNext = mContext.getResources().getString(R.string.the_top_25_played_tracks);
    	} else if (mEnqueueType.equals("RECENTLY_ADDED")) {
    		String selection = null;
            if (mApp.isGooglePlayMusicEnabled()==false) {
            	selection = DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'" + " AND "
            			  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
            } else {
            	selection = DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
            }
            
            mCursor = dbHelper.getRecentlyAddedSongs(selection);
            mPlayingNext =  mContext.getResources().getString(R.string.the_most_recently_added_songs);
    	} else if (mEnqueueType.equals("TOP_RATED")) {
    		String selection = null;
            if (mApp.isGooglePlayMusicEnabled()==false) {
            	selection = DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'" + " AND "
            			  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
            } else {
            	selection = DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
            }
            
            mCursor = dbHelper.getTopRatedSongs(selection);
            mPlayingNext =  mContext.getResources().getString(R.string.the_top_rated_songs);
    	} else if (mEnqueueType.equals("RECENTLY_PLAYED")) {
    		String selection = null;
            if (mApp.isGooglePlayMusicEnabled()==false) {
            	selection = DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'" + " AND "
            			  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
            } else {
            	selection = DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
            }
            
            mCursor = dbHelper.getRecentlyPlayedSongs(selection);
            mPlayingNext =  mContext.getResources().getString(R.string.the_most_recently_played_songs);
    	} else if (mEnqueueType.equals("PLAYLIST")) {
           /* String selection = " AND " + DBAccessHelper.MUSIC_LIBRARY_PLAYLISTS_NAME + "." 
            				 + DBAccessHelper.PLAYLIST_ID + "=" + "'" + mPlaylistId + "'";
            
            if (mApp.isGooglePlayMusicEnabled()) {
            	mCursor = dbHelper.getAllSongsInPlaylistSearchable(selection);
            } else {
            	mCursor = dbHelper.getLocalSongsInPlaylistSearchable(selection);
            }
    		
            mPlayingNext = mPlaylistName;*/
    	} else if (mEnqueueType.equals("GENRE")) {
    		
    		String selection = null;
    		if (mApp.isGooglePlayMusicEnabled()) {
    			selection = DBAccessHelper.SONG_GENRE + "=" + "'" + mGenreName + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'";
    		} else {
    			selection = DBAccessHelper.SONG_GENRE + "=" + "'" + mGenreName + "'" + " AND "
	   				 	  + DBAccessHelper.BLACKLIST_STATUS + "=" + "'FALSE'" + " AND "
  					  	  + DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
    		}
    		
    		mCursor = dbHelper.getReadableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
												   		   null, 
												   		   selection, 
												   		   null, 
												   		   null, 
												   		   null, 
												   		   DBAccessHelper.SONG_ALBUM + " ASC, " + 
												   		   DBAccessHelper.SONG_TRACK_NUMBER + "*1 ASC");
    		
    		mPlayingNext = mGenreName;
    	}
    	
    	
    }

