    @Override
    public void onDestroy() {
        super.onDestroy();
        saveLastPosition();

        mFadeInVolume = 0.0f;
        mFadeOutVolume = 1.0f;

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(mNotificationId);

        if (mMediaPlayer!=null)
            mMediaPlayer.release();

        if (mMediaPlayer2!=null)
            getMediaPlayer2().release();

        mMediaPlayer = null;
        mMediaPlayer2 = null;

        mAudioManagerHelper.setHasAudioFocus(false);
        mAudioManager.abandonAudioFocus(audioFocusChangeListener);
        mAudioManager = null;
    }

