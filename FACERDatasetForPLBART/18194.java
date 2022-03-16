	/**
	 * Returns a Uri of a specific genre in MediaStore. 
	 * The genre is specified using the genreId parameter.
	 */
	private Uri makeGenreUri(String genreId) {
        String CONTENTDIR = MediaStore.Audio.Genres.Members.CONTENT_DIRECTORY;
        return Uri.parse(new StringBuilder().append(MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI.toString())
        									.append("/")
        									.append(genreId)
        									.append("/")
        									.append(CONTENTDIR)
        									.toString());
    }

