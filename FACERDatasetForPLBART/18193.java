    /**
     * Returns the number of songs in the specified genre.
     */
    private int getGenreSongsCount(String genre) {
        if (mGenresSongCountHashMap!=null)
            if (genre!=null)
                if (mGenresSongCountHashMap.get(genre)!=null)
                    return mGenresSongCountHashMap.get(genre);
                else
                    return 0;
            else
                if (mGenresSongCountHashMap.get(mContext.getResources().getString(R.string.unknown_genre))!=null)
                    return mGenresSongCountHashMap.get(mContext.getResources().getString(R.string.unknown_genre));
                else
                    return 0;
        else
            return 0;
    }

