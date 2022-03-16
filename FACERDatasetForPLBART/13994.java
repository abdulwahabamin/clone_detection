    /**
     * @return album name from Bundle
     */
    public String getAlbumId() {
        if (bundle.getString(ALBUM_ID_KEY) != null)
            return bundle.getString(ALBUM_ID_KEY);
        return getResources().getString(R.string.butter_name);
    }

