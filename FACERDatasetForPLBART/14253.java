    /**
     * @param genre
     * @return parsed genre name
     */
    public static String parseGenreName(Context mContext, String genre) {
        int genre_id = -1;

        if (genre == null || genre.trim().length() <= 0)
            return mContext.getResources().getString(R.string.unknown);

        try {
            genre_id = Integer.parseInt(genre);
        } catch (NumberFormatException e) {
            return genre;
        }
        if (genre_id >= 0 && genre_id < GENRES_DB.length)
            return GENRES_DB[genre_id];
        else
            return mContext.getResources().getString(R.string.unknown);
    }

