    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() entry.");
        if (mediaSessionManager == null) {
            initMediaSession();
        }
        return super.onStartCommand(intent, flags, startId);
    }

