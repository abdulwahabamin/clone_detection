    @Override
    public void onCompletion(MediaPlayer mp) {
        if(!playQueue.isAtLastSong()) {
            next();

            for(final SongListener listener : songListenerList) {
                EasyHandler.executeOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        listener.onTrackAutoChanged();
                    }
                });
            }

            play();
        } else {
            for(final SongListener listener : songListenerList) {
                EasyHandler.executeOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSongStopped();
                        listener.onSeekUpdate(0);
                    }
                });
            }
            playerNotification.displayPlayerNotification(playQueue.getCurrentPlaying(), false, true);
            if(!isBound) {
                endService(false);
            }
        }
    }

