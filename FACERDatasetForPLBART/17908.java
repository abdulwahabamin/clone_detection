    private void updatePlaybackState() {
        if (mLastPlaybackState == null) {
            return;
        }
        if (mLastPlaybackState.getState() == PlaybackStateCompat.STATE_PLAYING) {
            mMvpView.showPauseIcon();
            mMvpView.scheduleSeekbarUpdate();
        } else if (mLastPlaybackState.getState() == PlaybackStateCompat.STATE_PAUSED) {
            mMvpView.showPlayIcon();
            mMvpView.stopSeekbarUpdate();

            //to set the seekbar to correct position if somehow paused at
            //a different position than shown on the ui
            updateProgress();
        } else if (mLastPlaybackState.getState() == PlaybackStateCompat.STATE_NONE
                || mLastPlaybackState.getState() == PlaybackStateCompat.STATE_ERROR
                || mLastPlaybackState.getState() == PlaybackStateCompat.STATE_STOPPED){
            mMvpView.showPlayIcon();
            mMvpView.stopSeekbarUpdate();
            mMvpView.resetSeekbar();
        }

        if (mLastPlaybackState
                .getExtras()
                .getBoolean(PlaylistsSource.PLAYBACK_STATE_EXTRA_IS_IN_FAVORITES)) {
            mMvpView.showFavButtonEnabled();
        } else {
            mMvpView.showFavButtonDisabled();
        }
    }

