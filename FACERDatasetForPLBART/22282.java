    /**
     * @param songId The song Id to remove.
     */
    public void removeItem(final long songId) {
        final SQLiteDatabase database = mMusicDatabase.getWritableDatabase();
        deleteEntry(database, String.valueOf(songId));
    }

