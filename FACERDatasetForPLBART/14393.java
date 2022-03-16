    private void gotoIdleState() {
        mDelayedStopHandler.removeCallbacksAndMessages(null);
        Message msg = mDelayedStopHandler.obtainMessage();
        mDelayedStopHandler.sendMessageDelayed(msg, IDLE_DELAY);
        stopForeground(false);
        if (status != null) {
            status.contentView.setImageViewResource(R.id.status_bar_play,
                    mIsSupposedToBePlaying ? R.drawable.butter_holo_dark_play
                            : R.drawable.butter_holo_dark_pause);
            status.bigContentView.setImageViewResource(R.id.status_bar_play,
                    mIsSupposedToBePlaying ? R.drawable.butter_holo_dark_play
                            : R.drawable.butter_holo_dark_pause);
            NotificationManager mManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            mManager.notify(PLAYBACKSERVICE_STATUS, status);
        }
    }

