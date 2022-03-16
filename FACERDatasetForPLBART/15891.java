    private File songRequest(long songId) {
        Cursor cursor = Library.getSong(null, songId);
        if(cursor.moveToFirst()) {
            return new File(Song.toSong(cursor).getFilePath());
        } else {
            return null; //TODO: something less destructive. This will cause the receiver to throw an exception due to null file
        }
    }

