    @Override
    public void onSeekUpdated(final int newSeek) {
        for(final SongListener listener : songListenerList) {
            EasyHandler.executeOnMainThread(new Runnable() {
                @Override
                public void run() {
                    listener.onSeekUpdate(newSeek);
                }
            });
        }
    }

