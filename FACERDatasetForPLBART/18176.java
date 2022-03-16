	@Override
	protected Boolean doInBackground(String... params) {
		
		//We'll create a matrix cursor that includes all the audio files within the specified folder.
		String[] foldersCursorColumns = { DBAccessHelper.SONG_ARTIST,  
										  DBAccessHelper.SONG_ALBUM, 
										  DBAccessHelper.SONG_TITLE, 
										  DBAccessHelper.SONG_FILE_PATH,
										  DBAccessHelper.SONG_DURATION, 
										  DBAccessHelper.SONG_GENRE, 
										  DBAccessHelper.SONG_SOURCE, 
										  DBAccessHelper.SONG_ALBUM_ART_PATH, 
										  DBAccessHelper.SONG_ID, 
										  DBAccessHelper.LOCAL_COPY_PATH };
					    		
		MatrixCursor foldersCursor = new MatrixCursor(foldersCursorColumns);
		String artist = "";
		String album = "";
		String title = "";
		String filePath = "";
		String duration = "";
		String genre = "";
		String songSource = "LOCAL_FILE";
		String songAlbumArtPath = "";
		String songId = "";
		
		for (int i=0; i < mSongFilePathsList.size(); i++) {
			
			if (mSongFilePathsList.size() <= 5 && i==5) {
				mApp.getService().setCursor((Cursor) foldersCursor);
			}
			
			/*//Extract metadata from the file, (if it exists).
			try {
				mmdr.setDataSource(mSongFilePathsList.get(i));
			} catch (Exception e) {
				//Skip the audio file if we can't read it.
				continue;
			}
			
			artist = mmdr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
			if (artist==null || artist.isEmpty()) {
				artist = "Unknown Artist";
			}
			
			album = mmdr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
			if (album==null || album.isEmpty()) {
				album = "Unknown Album";
			}
			
			title = mmdr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
			if (title==null || title.isEmpty()) {
				title = mSongFilePathsList.get(i);
			}
			
			filePath = mSongFilePathsList.get(i);
			duration = mmdr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
			if (duration==null || duration.isEmpty()) {
				duration = "0";
			}
			
			genre = mmdr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);
			if (genre==null || genre.isEmpty()) {
				genre = "Unknown Genre";
			}*/
			
			try {
				File file = new File(mSongFilePathsList.get(i));
    			AudioFile audioFile = AudioFileIO.read(file);
    			Tag tag = audioFile.getTag();
    			filePath = mSongFilePathsList.get(i);
    			
    			artist = tag.getFirst(FieldKey.ARTIST);
    			if (artist==null || artist.equals(" ") || artist.isEmpty()) {
    				artist = "Unknown Artist";
    			}
    			
    			album = tag.getFirst(FieldKey.ALBUM);
    			if (album==null || album.equals(" ") || album.isEmpty()) {
    				album = "Unknown Album";
    			}
    			
    			title = tag.getFirst(FieldKey.ARTIST);
    			if (title==null || title.equals(" ") || title.isEmpty()) {
    				title = filePath;
    			}
    			
    			duration = "" + audioFile.getAudioHeader().getTrackLength();
    			if (duration==null || duration.equals(" ") || duration.isEmpty()) {
    				duration = "0";
    			}
    			
    			genre = tag.getFirst(FieldKey.GENRE);
    			if (genre==null || genre.equals(" ") || genre.isEmpty()) {
    				genre = "Unknown Genre";
    			}
    			
    			foldersCursor.addRow(new Object[] { artist,
    												album,
    												title,
    												filePath,
    												duration,
    												genre,
    												songSource,
    												songAlbumArtPath,
    												songId, 
    												"" });
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			
		}
		
		//cursor = (Cursor) foldersCursor;
		mApp.getService().setCursor((Cursor) foldersCursor);
		
		return null;
	}

