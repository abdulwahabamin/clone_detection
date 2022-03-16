    private Boolean RunServiceIfnot(int isPlayFromMain,int isNextorPre,int position){
        Cursor mCursor= MediaStoreAccessHelper.getAllSongs(mContext, null, null);
        if(!UtilFunctions.isServiceRunning(SongPlayback.class.getName(), mContext)){

            Intent i = new Intent(getApplicationContext(),SongPlayback.class);

            if (isNextorPre==MainActivity.forSkipTrack) {
                setSongPlay(PlayerConstants.SONG_NUMBER,position);
                PlayerConstants.SONG_NUMBER=position;
            }
            else if (isNextorPre==MainActivity.forNothingKey || isNextorPre==MainActivity.forPreviousKey) {
                mHandler.post(loadLastPosition);
            }

            //i.putExtra(SongPlayback.isStartFromMain, true);

            i.putExtra(SongPlayback.RestartServiceAction, isNextorPre);
            i.putExtra(SongPlayback.isPlayFromMain, isPlayFromMain);

            startService(i);
            return false;
        }
        else if (PlayerConstants.SONGS_LIST.size()!=mCursor.getCount())
        {
            Intent i = new Intent(getApplicationContext(),WelcomeActivity.class);
            i.putExtra(SongPlayback.isPlayFromMain, isPlayFromMain);
            i.putExtra(SongPlayback.RestartServiceAction, isNextorPre);
            startActivity(i);
            activity.finish();
            return false;
        }
        return true;
    }

