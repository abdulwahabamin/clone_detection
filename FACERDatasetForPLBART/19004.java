    private String determineAlbumArtPath() {
        if (mApp.getService().getCursor().getColumnIndex(MediaStore.Audio.Media.IS_MUSIC)==-1) {
            //We're dealing with Jams' internal DB schema.
            int colIndex = mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_ALBUM_ART_PATH);
            return mApp.getService().getCursor().getString(colIndex);
        } else {
            String isMusicColName = MediaStore.Audio.Media.IS_MUSIC;
            int isMusicColumnIndex = mApp.getService().getCursor().getColumnIndex(isMusicColName);

            //Check if the current row is from Jams' internal DB schema or MediaStore.
            if (mApp.getService().getCursor().getString(isMusicColumnIndex).isEmpty()) {
                //We're dealing with Jams' internal DB schema.
                int colIndex = mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_ALBUM_ART_PATH);
                return mApp.getService().getCursor().getString(colIndex);

            } else {
                //The current row is from MediaStore's DB schema.
                final Uri ART_CONTENT_URI = Uri.parse("content://media/external/audio/albumart");
                int albumIdColIndex = mApp.getService().getCursor().getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
                long albumId = mApp.getService().getCursor().getLong(albumIdColIndex);

                return ContentUris.withAppendedId(ART_CONTENT_URI, albumId).toString();

            }

        }

    }

