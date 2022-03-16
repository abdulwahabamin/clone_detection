    private String determineGenreName(Context context) {
        if (mApp.getService().getCursor().getColumnIndex(MediaStore.Audio.Media.IS_MUSIC)==-1) {
            //We're dealing with Jams' internal DB schema.
            int colIndex = mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_GENRE);
            return mApp.getService().getCursor().getString(colIndex);
        } else {
            String isMusicColName = MediaStore.Audio.Media.IS_MUSIC;
            int isMusicColumnIndex = mApp.getService().getCursor().getColumnIndex(isMusicColName);

            //Check if the current row is from Jams' internal DB schema or MediaStore.
            if (mApp.getService().getCursor().getString(isMusicColumnIndex).isEmpty()) {
                //We're dealing with Jams' internal DB schema.
                int colIndex = mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_GENRE);
                return mApp.getService().getCursor().getString(colIndex);

            } else {
                //The current row is from MediaStore's DB schema.
                return ""; //We're not using the genres field for now, so we'll leave it blank.

            }

        }

    }

