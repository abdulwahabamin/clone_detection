	public void getSongTags(ArrayList<String> dataURIsList) throws CannotReadException, 
																   IOException, 
																   TagException, 
																   ReadOnlyFileException, 
																   InvalidAudioFrameException {

		Cursor cursor = null;
		for (int i=0; i < dataURIsList.size(); i++) {
			
			//Check if the song is from Google Play Music.
			if (songSourcesList.get(i).equals(DBAccessHelper.GMUSIC)) {
				
				String songId = songIdsList.get(i);
				cursor = mApp.getDBAccessHelper().getSongById(songId);
				cursor.moveToFirst();
				
				titlesList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_TITLE)));
				artistsList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ARTIST)));
				albumsList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ALBUM)));
				albumArtistsList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_ALBUM_ARTIST)));
				genresList.add("");
				producersList.add("");
				yearsList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_YEAR)));
				trackNumbersList.add(cursor.getString(cursor.getColumnIndex(DBAccessHelper.SONG_TRACK_NUMBER)));
				totalTracksList.add("");
				commentsList.add("");
				
			} else {
				File file = null;
				try {
					file = new File(dataURIsList.get(i));
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
				AudioFile audioFile = AudioFileIO.read(file);
				
				titlesList.add(audioFile.getTag().getFirst(FieldKey.TITLE));
				artistsList.add(audioFile.getTag().getFirst(FieldKey.ARTIST));
				albumsList.add(audioFile.getTag().getFirst(FieldKey.ALBUM));
				albumArtistsList.add(audioFile.getTag().getFirst(FieldKey.ALBUM_ARTIST));
				genresList.add(audioFile.getTag().getFirst(FieldKey.GENRE));
				producersList.add(audioFile.getTag().getFirst(FieldKey.PRODUCER));
				yearsList.add(audioFile.getTag().getFirst(FieldKey.YEAR));
				trackNumbersList.add(audioFile.getTag().getFirst(FieldKey.TRACK));
				totalTracksList.add(audioFile.getTag().getFirst(FieldKey.TRACK_TOTAL));
				commentsList.add(audioFile.getTag().getFirst(FieldKey.COMMENT));
				
			}
			
		}
		
		if (cursor!=null) {
			cursor.close();
			cursor = null;
		}
		
	}

