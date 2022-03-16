	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//Music folders table.
		String[] musicFoldersTableCols = { FOLDER_PATH, INCLUDE };
		String[] musicFoldersTableColTypes = { "TEXT", "TEXT" };
		String createMusicFoldersTable = buildCreateStatement(MUSIC_FOLDERS_TABLE, 
																musicFoldersTableCols, 
																musicFoldersTableColTypes);
		
		//Equalizer table.
		String[] equalizerTableCols = { SONG_ID, EQ_50_HZ, EQ_130_HZ, 
										EQ_320_HZ, EQ_800_HZ, EQ_2000_HZ, 
										EQ_5000_HZ, EQ_12500_HZ, VIRTUALIZER, 
										BASS_BOOST, REVERB };
		
		String[] equalizerTableColTypes = { "TEXT", "TEXT", "TEXT", 
											"TEXT", "TEXT", "TEXT", 
											"TEXT", "TEXT", "TEXT", 
											"TEXT", "TEXT" };
		
		String createEqualizerTable = buildCreateStatement(EQUALIZER_TABLE, 
															 equalizerTableCols,
															 equalizerTableColTypes);
		
		//Equalizer presets table.
		String[] equalizerPresetsTableCols = { PRESET_NAME, EQ_50_HZ, EQ_130_HZ, 
											   EQ_320_HZ, EQ_800_HZ, EQ_2000_HZ, 
											   EQ_5000_HZ, EQ_12500_HZ, VIRTUALIZER, 
											   BASS_BOOST, REVERB };
		
		String[] equalizerPresetsTableColTypes = { "TEXT", "TEXT", "TEXT", 
												   "TEXT", "TEXT", "TEXT", 
												   "TEXT", "TEXT", "TEXT", 
												   "TEXT", "TEXT" };
		
		String createEqualizerPresetsTable = buildCreateStatement(EQUALIZER_PRESETS_TABLE, 
															 		equalizerPresetsTableCols,
															 		equalizerPresetsTableColTypes);
		
		//Custom libraries table.
		String[] librariesTableCols = { LIBRARY_NAME, LIBRARY_TAG, SONG_ID };
		String[] librariesTableColTypes = { "TEXT", "TEXT", "TEXT" };
		String createLibrariesTable = buildCreateStatement(LIBRARIES_TABLE, 
															 librariesTableCols,
															 librariesTableColTypes);
		
		//Music library table.
		String[] musicLibraryTableCols = { SONG_ID, SONG_TITLE, SONG_ARTIST, 
			    						   SONG_ALBUM, SONG_ALBUM_ARTIST, 
			    						   SONG_DURATION, SONG_FILE_PATH, 
			    						   SONG_TRACK_NUMBER, SONG_GENRE, 
			    						   SONG_PLAY_COUNT, SONG_YEAR, ALBUMS_COUNT,
			    						   SONGS_COUNT, GENRES_SONG_COUNT, SONG_LAST_MODIFIED, SONG_SCANNED,
			    						   BLACKLIST_STATUS, ADDED_TIMESTAMP, RATING, 
			    						   LAST_PLAYED_TIMESTAMP, SONG_SOURCE, SONG_ALBUM_ART_PATH,
			    						   SONG_DELETED, ARTIST_ART_LOCATION, ALBUM_ID, 
			    						   ARTIST_ID, GENRE_ID, GENRE_SONG_COUNT, 
			    						   LOCAL_COPY_PATH, LIBRARIES, SAVED_POSITION };
		
		String[] musicLibraryTableColTypes = new String[musicLibraryTableCols.length];
		for (int i=0; i < musicLibraryTableCols.length; i++)
			musicLibraryTableColTypes[i] = "TEXT";
			
		String createMusicLibraryTable = buildCreateStatement(MUSIC_LIBRARY_TABLE, 
															  musicLibraryTableCols,
															  musicLibraryTableColTypes);	

		//Execute the CREATE statements.
		db.execSQL(createMusicFoldersTable);
		db.execSQL(createEqualizerTable);
		db.execSQL(createEqualizerPresetsTable);
		db.execSQL(createLibrariesTable);
		db.execSQL(createMusicLibraryTable);
				
	}

