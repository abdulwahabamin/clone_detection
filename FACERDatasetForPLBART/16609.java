    @Override
    public void onTaskRemoved(Intent rootIntent) {
        FireLog.d(TAG, "(++) onTaskRemoved");
        super.onTaskRemoved(rootIntent);
        stopSelf();
    }

