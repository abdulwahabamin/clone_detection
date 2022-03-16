    private void gotoIdleState() {
        mDelayedStopHandler.removeCallbacksAndMessages(null);
        mDelayedStopHandler.sendMessageDelayed(mDelayedStopHandler.obtainMessage(), IDLE_DELAY_MILLIS);
        stopForeground(true);
        if (mSession != null) {
            if (isMediaSessionActive()) {
                updateMediaSession(false);
            }
        }
        mIsSupposedToBePlaying = false;
    }

