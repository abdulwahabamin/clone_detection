    /**
     * Deletes the entry
     *
     * @param database database to use
     * @param stringId id to delete
     */
    private void deleteEntry(final SQLiteDatabase database, final String stringId) {
        database.delete(SongPlayCountColumns.NAME, WHERE_ID_EQUALS, new String[]{stringId});
    }

