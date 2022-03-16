	public void getSongTags(ArrayList<String> dataURIsList) throws CannotReadException, 
																   IOException, 
																   TagException, 
																   ReadOnlyFileException, 
																   InvalidAudioFrameException {
		
		for (int i=0; i < dataURIsList.size(); i++) {
			
			try {
				File file = new File(dataURIsList.get(i));
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
				
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			
		}
		
	}

