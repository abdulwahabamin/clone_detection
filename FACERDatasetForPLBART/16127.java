    private void callSeekListeners() {
        if(mediaPlayer != null && prepared) {
            int currentPos = mediaPlayer.getCurrentPosition();

            for (SeekListener listener : seekListenerList) {
                listener.onSeekUpdated(currentPos * MAX_SEEK_VALUE / mediaPlayer.getDuration());
            }
        }
    }

