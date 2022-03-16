    private void updatePlaybackState() {
        if (mLastPlaybackState == null) {
            return;
        }
        if (mLastPlaybackState .getState() == PlaybackStateCompat.STATE_PLAYING) {
            mMvpView.showPauseIcon();
            mMvpView.scheduleSeekbarUpdate();
        } else if (mLastPlaybackState .getState() == PlaybackStateCompat.STATE_PAUSED) {
            mMvpView.showPlayIcon();
            mMvpView.stopSeekbarUpdate();
        } else if (mLastPlaybackState .getState() == PlaybackStateCompat.STATE_NONE
                || mLastPlaybackState .getState() == PlaybackStateCompat.STATE_ERROR
                || mLastPlaybackState .getState() == PlaybackStateCompat.STATE_STOPPED) {
            mMvpView.showPlayIcon();
            mMvpView.stopSeekbarUpdate();
            mMvpView.resetSeekbar();
        }
    }

