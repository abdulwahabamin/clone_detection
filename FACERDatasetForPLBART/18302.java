    @Override
    protected Void doInBackground(String... params) {
    	/*
    	try {
    		int currentPlayCount = 0;
    		mApp.getService().getCursor().moveToPosition(mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex()));
    		if (mApp.getService().getCursor().getString(mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_SOURCE)).equals(DBAccessHelper.GMUSIC)) {
    			
    		} else {
    			//Increment the play counter for the song.
    			try {
    				
    				File file = new File(mApp.getService().getCursor().getString(mApp.getService().getCursor().getColumnIndex(AudioPlaybackService.getSongFilePathColumn())));
    				AudioFile audioFile = null;
    				try {
    					audioFile = AudioFileIO.read(file);
    				} catch (CannotReadException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (TagException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (ReadOnlyFileException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (InvalidAudioFrameException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    				
    				Tag tag = null;
    				try {
    					tag = audioFile.getTag();
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    				
    				//Get the current play count for the song.
    				currentPlayCount = 0;
    				try {
    					currentPlayCount = Integer.parseInt(tag.getFirst(FieldKey.CUSTOM1));
    				} catch (Exception e) {
    					currentPlayCount = 0;
    				} finally {
    					
    					currentPlayCount++;
    					try {
    						tag.setField(FieldKey.CUSTOM1, "" + currentPlayCount);
    					} catch (KeyNotFoundException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    						try {
    							tag.createField(FieldKey.CUSTOM1, "" + currentPlayCount);
    						} catch (Exception e1) {
    							e.printStackTrace();
    						}
    						
    					} catch (FieldDataInvalidException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					} catch (Exception e) {
    						//Nothing much we can do about this exception. :/
    					}
    					
    					try {
    						audioFile.commit();
    					} catch (CannotWriteException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    					
    				}
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			
    		}

    		//Update the last played timestamp in the DB.
    		DBAccessHelper dbHelper = new DBAccessHelper(mContext);
    		dbHelper.updateLastPlayedTimestamp(mApp.getService().getCursor().getString(
    										   mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_FILE_PATH)));
        	
        	//Get the file path and updated play count of the current song.
        	String filePath = params[0];
        	
        	if (filePath!=null) {
        		
            	if (filePath.contains("'")) {
            		filePath = filePath.replace("'", "''");
            	}
            	
            	String where = DBAccessHelper.SONG_FILE_PATH + "=" + "'" + filePath + "'";
            	
            	ContentValues values = new ContentValues();
            	values.put(DBAccessHelper.SONG_PLAY_COUNT, currentPlayCount);
            	
            	dbHelper.getWritableDatabase().update(DBAccessHelper.MUSIC_LIBRARY_TABLE, values, where, null);
            	
        	}
        	
        	dbHelper.close();
        	dbHelper = null;
        	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	*/
    	return null;
    }

