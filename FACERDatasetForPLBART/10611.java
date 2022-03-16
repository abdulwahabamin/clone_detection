    /**
     * Method that converts a content uri to a file system path
     *
     * @param cr The content resolver
     * @param id The media database id
     * @param volume The volume
     * @return File The file reference
     */
    private static File mediaIdToFile(ContentResolver cr, long id, String volume) {
        final String[] projection = {MediaColumns.DATA};
        final String where = MediaColumns._ID + " = ?";
        Uri baseUri = MediaStore.Files.getContentUri(volume);
        Cursor c = cr.query(baseUri, projection, where, new String[]{String.valueOf(id)}, null);
        try {
            if (c != null && c.moveToNext()) {
                return new File(c.getString(c.getColumnIndexOrThrow(MediaColumns.DATA)));
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return null;
    }

