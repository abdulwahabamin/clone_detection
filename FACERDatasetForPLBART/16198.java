    public void play(){
        boolean playbackSuccessful = player.playSong(playQueue.getCurrentPlaying());

        if(playbackSuccessful) {
            startForeground(0, null);
            playerNotification.displayPlayerNotification(playQueue.getCurrentPlaying(), true, true);

            for(final SongListener listener : songListenerList) {
                EasyHandler.executeOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSongStarted(playQueue.getCurrentPlaying());
                    }
                });
            }
        } else {
            for(final SongListener listener : songListenerList) {
                EasyHandler.executeOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSongPlaybackFailed();
                    }
                });
            }
        }
    }

