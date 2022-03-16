    @Override
    public void onPrepared(final MediaPlayer mp) {
        updateDuration("0:00", milliSecondsToTimer(mp.getDuration()));
        startTimer();
        mp.start();
        playerNotification(Constants.ACTION_PLAY);
        updateSongCount();
    }

