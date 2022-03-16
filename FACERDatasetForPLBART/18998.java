    private int getFilePathColumnIndex() {
        if (mApp.getService().getCursor().getColumnIndex(MediaStore.Audio.Media.IS_MUSIC)==-1) {
            //We're dealing with Jams' internal DB schema.
            return mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_FILE_PATH);
        } else {
            String isMusicColName = MediaStore.Audio.Media.IS_MUSIC;
            int isMusicColumnIndex = mApp.getService().getCursor().getColumnIndex(isMusicColName);

            //Check if the current row is from Jams' internal DB schema or MediaStore.
            if (mApp.getService().getCursor().getString(isMusicColumnIndex).isEmpty())
                //We're dealing with Jams' internal DB schema.
                return mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_FILE_PATH);
            else
                //The current row is from MediaStore's DB schema.
                return mApp.getService().getCursor().getColumnIndex(MediaStore.Audio.Media.DATA);

        }

    }

