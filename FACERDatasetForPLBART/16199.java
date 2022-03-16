    public void pause(){
        player.pauseSong();
        playerNotification.displayPlayerNotification(playQueue.getCurrentPlaying(), false, false);
        editor.putInt(LAST_SEEK, player.getTrueSeek()).apply();

        for(final SongListener listener : songListenerList) {
            EasyHandler.executeOnMainThread(new Runnable() {
                @Override
                public void run() {
                    listener.onSongStopped();
                }
            });
        }

        if(!isBound) {
            endService(false);
        }
    }

