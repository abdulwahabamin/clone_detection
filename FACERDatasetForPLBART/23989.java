        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.i(TAG, "mIntentReceiver.onReceive: " + action);
            if (AudioManager.ACTION_AUDIO_BECOMING_NOISY.equals(action)) {
                pause();
            } else if (PREVIOUS_ACTION.equals(action)) {
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
            } else {
                handleAdditionalActions(intent);
            }
        }

