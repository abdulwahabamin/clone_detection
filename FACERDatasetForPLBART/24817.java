    public void LoadSongList(Boolean isFromMain) {
        Cursor cursor= MediaStoreAccessHelper.getAllSongs(mContext, null, null);
        if (isFromMain)
        {
            if (cursor.getCount()!=PlayerConstants.SONGS_LIST.size()) {
                if (!UtilFunctions.isServiceRunning(LoadSongsService.class.getName(), getApplicationContext())) {
                    Intent intent = new Intent(getApplicationContext(), LoadSongsService.class);
                    startService(intent);
                }
            }
        }
        else {
            if (!UtilFunctions.isServiceRunning(LoadSongsService.class.getName(), getApplicationContext())) {
                Intent intent = new Intent(getApplicationContext(), LoadSongsService.class);
                startService(intent);
            }
        }
    }

