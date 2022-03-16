    @Override
    public void onPlaybackStart() {
        FireLog.d(TAG, "(++) onPlaybackStart");
        session.setActive(true);

        delayedStopHandler.removeCallbacksAndMessages(null);

        startService(new Intent(getApplicationContext(), MusicPlayerService.class));
    }

