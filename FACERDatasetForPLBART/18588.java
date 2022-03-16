	public void getSongTags(String uri) throws CannotReadException, 
											   IOException, 
											   TagException, 
											   ReadOnlyFileException, 
											   InvalidAudioFrameException {
			
		File file = new File(uri);
		AudioFile audioFile = AudioFileIO.read(file);
		
		if (audioFile!=null && audioFile.getTag()!=null) {
			titleEditText.setText(audioFile.getTag().getFirst(FieldKey.TITLE));
			artistEditText.setText(audioFile.getTag().getFirst(FieldKey.ARTIST));
			albumEditText.setText(audioFile.getTag().getFirst(FieldKey.ALBUM));
			albumArtistEditText.setText(audioFile.getTag().getFirst(FieldKey.ALBUM_ARTIST));
			genreEditText.setText(audioFile.getTag().getFirst(FieldKey.GENRE));
			producerEditText.setText(audioFile.getTag().getFirst(FieldKey.PRODUCER));
			yearEditText.setText(audioFile.getTag().getFirst(FieldKey.YEAR));
			trackEditText.setText(audioFile.getTag().getFirst(FieldKey.TRACK));
			trackTotalEditText.setText(audioFile.getTag().getFirst(FieldKey.TRACK_TOTAL));
			commentsEditText.setText(audioFile.getTag().getFirst(FieldKey.COMMENT));
			
		}

	}

