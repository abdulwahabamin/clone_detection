    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand intent=" + intent + " flags=" + flags + " startId=" + startId);

        mServiceStartId = startId;
        mDelayedStopHandler.removeCallbacksAndMessages(null);

        if (intent != null) {
            String action = intent.getAction();

            if (PREVIOUS_ACTION.equals(action)) {
                previousOrRestartCurrent();
            } else if (NEXT_ACTION.equals(action)) {
                next();
            } else if (TOGGLEPAUSE_ACTION.equals(action)) {
                if (isPlaying()) {
                    pause();
                } else {
                    play();
                }
            } else if (PLAY_ACTION.equals(action)) {
                play();
            } else if (PAUSE_ACTION.equals(action)) {
                pause();
            } else if (STOP_ACTION.equals(action)) {
                pause();
                seek(0);
                if (mSession != null) {
                    deactivateMediaSession();
                }
            }
        }

        // make sure the service will shut down on its own if it was
        // just started but not bound to and nothing is playing
        mDelayedStopHandler.removeCallbacksAndMessages(null);
        Message msg = mDelayedStopHandler.obtainMessage();
        mDelayedStopHandler.sendMessageDelayed(msg, IDLE_DELAY_MILLIS);
        return START_STICKY;
    }

