    /**
     * Method that query the media database for search a path an translate
     * to the internal media id
     *
     * @param path The path to search
     * @return long The id of the resource, or -1 if not found
     */
    public long getIdFromPath(String path) {
        try {
            // Remove schema for search in the database
            // Otherwise the file will not found
            String data = path;
            if( data.startsWith("file://") ){
                data = data.substring(7);
            }
            ContentResolver resolver = getContentResolver();
            String where = MediaColumns.DATA + "=?";
            String selectionArgs[] = new String[] {
                data
            };
            Cursor cursor =
                    resolver.query(
                            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                            mCursorCols, where, selectionArgs, null);
            try {
                if (cursor == null || cursor.getCount() == 0) {
                    return -1;
                }
                cursor.moveToNext();
                return cursor.getLong(IDCOLIDX);
            } finally {
                try {
                    if( cursor != null )
                        cursor.close();
                } catch (Exception ex) {
                }
            }
        } catch (UnsupportedOperationException ex) {
        }
        return -1;
    }

