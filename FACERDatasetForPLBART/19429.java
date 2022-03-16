	public String getSongTitle(String songFilePath) {
		
		String songTitle = "Title";
		
		//Try to get the song title from the ID3 tag.
		File songFile = new File(songFilePath);
		AudioFile audioFile = null;
		Tag tag = null;
		try {
			audioFile = AudioFileIO.read(songFile);
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
		
		tag = audioFile.getTag();
		songTitle = tag.getFirst(FieldKey.TITLE);
		
		//If the ID3 tag doesn't give us the info we need, just use the file name.
		if (songTitle.equals("Title") || songTitle.isEmpty()) {
			int indexOfLastSlash = songTitle.lastIndexOf("/")+1;
			int indexOfLastDot = songTitle.lastIndexOf(".");
			songTitle = songTitle.substring(indexOfLastSlash, indexOfLastDot);
		}
		
		return songTitle;
		
	}

