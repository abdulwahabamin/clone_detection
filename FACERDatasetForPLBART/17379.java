    @Override
    public int onStartCommand(Intent startIntent,int flags, int startId) {
        Log.d(TAG, "onStartCommand:called");

        if (startIntent != null) {
            String action = startIntent.getAction();
            String command = startIntent.getStringExtra(CMD_NAME);
            if (ACTION_CMD.equals(action)) {
                if (CMD_PAUSE.equals(command)) {
                    mPlaybackManager.handlePauseRequest();
                }
            }
        }
        return START_STICKY;
    }

