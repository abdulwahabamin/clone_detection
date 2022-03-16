	public boolean saveSongTags(String uri) {
		
		File file = new File(uri);
		AudioFile audioFile = null;
		
		//Update the DB entries.
		DBAccessHelper dbHelper = new DBAccessHelper(mContext.getApplicationContext());
		
		//Escape any rogue apostrophes.
		if (SONG_URI.contains("'")) {
			SONG_URI = SONG_URI.replace("'", "''");
		}
		
		String whereClause = DBAccessHelper.SONG_FILE_PATH + "=" + "'" + SONG_URI + "'";
		
		ContentValues values = new ContentValues();
		
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
		
		Tag tag = audioFile.getTag();
		
		if (tag!=null) {
			if (titleEdited==false) {
				//Don't do anything here. The user didn't change the title.
			} else {
				try {
					tag.setField(FieldKey.TITLE, titleEditText.getText().toString());
				} catch (KeyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FieldDataInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String title = titleEditText.getText().toString();
				if (title.contains("'")) {
					title = title.replace("'", "''");
				}
				
				values.put(DBAccessHelper.SONG_TITLE, title);
				
			}
			
			if (albumEdited==false) {
				//Don't do anything here. The user didn't change the album.
			} else {
				try {
					tag.setField(FieldKey.ALBUM, albumEditText.getText().toString());
				} catch (KeyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FieldDataInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String album = albumEditText.getText().toString();
				if (album.contains("'")) {
					album = album.replace("'", "''");
				}
				
				values.put(DBAccessHelper.SONG_ALBUM, album);
				
			}
			
			if (artistEdited==false) {
				//Don't do anything here. The user didn't change the artist.
			} else {
				try {
					tag.setField(FieldKey.ARTIST, artistEditText.getText().toString());
				} catch (KeyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FieldDataInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String artist = artistEditText.getText().toString();
				if (artist.contains("'")) {
					artist = artist.replace("'", "''");
				}
				
				values.put(DBAccessHelper.SONG_ARTIST, artist);
				
			}
			
			if (albumArtistEdited==false) {
				//Don't do anything here. The user didn't change the album artist.
			} else {
				try {
					tag.setField(FieldKey.ALBUM_ARTIST, albumArtistEditText.getText().toString());
				} catch (KeyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FieldDataInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String albumArtist = albumArtistEditText.getText().toString();
				if (albumArtist.contains("'")) {
					albumArtist = albumArtist.replace("'", "''");
				}
				values.put(DBAccessHelper.SONG_ALBUM_ARTIST, albumArtist);
				
			}
			
			if (genreEdited==false) {
				//Don't do anything here. The user didn't change the genre.
			} else {
				try {
					tag.setField(FieldKey.GENRE, genreEditText.getText().toString());
				} catch (KeyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FieldDataInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if (producerEdited==false) {
				//Don't do anything here. The user didn't change the producer.
			} else {
				try {
					tag.setField(FieldKey.PRODUCER, producerEditText.getText().toString());
				} catch (KeyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FieldDataInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if (yearEdited==false) {
				//Don't do anything here. The user didn't change the year.
			} else {
				try {
					tag.setField(FieldKey.YEAR, yearEditText.getText().toString());
				} catch (KeyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FieldDataInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String year = yearEditText.getText().toString();
				if (year.contains("'")) {
					year = year.replace("'", "''");
				}
				
				values.put(DBAccessHelper.SONG_YEAR, year);
				
			}
			
			if (trackEdited==false) {
				//Don't do anything here. The user didn't change the track number.
			} else {
				try {
					tag.setField(FieldKey.TRACK, trackEditText.getText().toString());
				} catch (KeyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FieldDataInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String track = trackEditText.getText().toString();
				if (track.contains("'")) {
					track = track.replace("'", "''");
				}
				
				values.put(DBAccessHelper.SONG_TRACK_NUMBER, track);
				
			}
			
			try {
				tag.setField(FieldKey.TRACK_TOTAL, trackTotalEditText.getText().toString());
			} catch (KeyNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FieldDataInvalidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (commentEdited==false) {
				//Don't do anything here. The user didn't change the comments.
			} else {
				try {
					tag.setField(FieldKey.COMMENT, commentsEditText.getText().toString());
				} catch (KeyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FieldDataInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			try {
				audioFile.commit();
			} catch (CannotWriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Write the values to the DB.
			if (values.size()!=0) {
				//Write the values to the DB.
				try {
					dbHelper.getWritableDatabase().update(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
														  values, 
														  whereClause, 
														  null);

					dbHelper.close();
					dbHelper = null;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		} else {
			Toast.makeText(mContext, R.string.unable_to_edit_song_tags, Toast.LENGTH_SHORT).show();
		}

		return true;
		
	}

