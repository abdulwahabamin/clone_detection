	/**
	 * Returns the genre of the song at the specified file path.
	 */
	private String getSongGenre(String filePath) {
        if (mGenresHashMap!=null)
		    return mGenresHashMap.get(filePath);
        else
            return mContext.getResources().getString(R.string.unknown_genre);
	}

