    public boolean prepareMediaPlayer2(int songIndex) {

        try {
            //Stop here if we're at the end of the queue.
            if (songIndex==-1 || songIndex+1>PlayerConstants.SONGS_LIST.size())
                return true;

            //Reset mMediaPlayer2 to its uninitialized state.
            getMediaPlayer2().reset();

    		/*
    		 * Set the data source for mMediaPlayer and start preparing it
    		 * asynchronously.
    		 */
            getMediaPlayer2().setDataSource(mContext, Uri.parse(PlayerConstants.SONGS_LIST.get(songIndex).getFilepath()));
            getMediaPlayer2().setOnPreparedListener(mediaPlayer2Prepared);
            getMediaPlayer2().setOnErrorListener(onErrorListener);
            getMediaPlayer2().prepareAsync();

        } catch (Exception e) {
            if (!isAtEndOfQueue())
                prepareMediaPlayer2(songIndex+1);
            else
                return false;

            return false;
        }

        return true;
    }

