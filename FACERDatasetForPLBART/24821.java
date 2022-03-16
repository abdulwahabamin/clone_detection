    public boolean prepareMediaPlayer(int songIndex) {
        try {
            if (songIndex==-1 || songIndex+1>PlayerConstants.SONGS_LIST.size())
            {
                return false;
            }


            getMediaPlayer().reset();
            if (mFirstRun) {
                startForeground(mNotificationId, buildNotification());
            }

            getMediaPlayer().setDataSource(mContext, Uri.parse(PlayerConstants.SONGS_LIST.get(songIndex).getFilepath()));
            getMediaPlayer().setOnPreparedListener(mediaPlayerPrepared);
            getMediaPlayer().setOnErrorListener(onErrorListener);
            getMediaPlayer().prepareAsync();

        } catch (Exception e) {
        }

        return true;
    }

