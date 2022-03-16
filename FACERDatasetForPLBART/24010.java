    private void fetchMetadata(long audioId) {
        resetMetadata();
        Cursor cursor = getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                CURSOR_COLS, "_id=" + String.valueOf(audioId), null, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    mArtistName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ARTIST));
                    mArtistId = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ARTIST_ID));
                    mAlbumName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ALBUM));
                    mAlbumId = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ALBUM_ID));
                    mMimeType = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.MIME_TYPE));
                    mFolder = new File(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DATA))).getParentFile();
                    mTrackName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.TITLE));

                    IdAndName idAndName = MusicUtils.fetchGenre(this, audioId);
                    if (idAndName != null) {
                        mGenreId = idAndName.id;
                        mGenreName = idAndName.name;
                    }

                    if (mSession != null) {
                        updateMediaMetadata();
                    }
                }
            } finally {
                cursor.close();
            }
        }
    }

