    private void tellTheWorld(String status) {
        boolean isPlaying = SERVICE_NOW_PLAYING.equals(status);
        Log.d(TAG, "tellTheWorld(" + status + ") isPlaying=" + isPlaying);

        notifyMainActivity(status);
        setMediaSessionState(isPlaying);
        if (isPlaying) {
            setupForegroundNotification();
            updateMetaData();
        }
    }

