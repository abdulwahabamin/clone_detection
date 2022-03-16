    private synchronized void updateSeekBar() {
        //Log.d(TAG, "updateSeekBar() Entry.");
        if (!mUserIsSeeking) {
            int duration = getDuration();
            mSeekBar.setMax(duration);
            mDuration.setText(formatDuration(duration));

            int currPos = getCurrentPosition();
            mSongPosition.setText(formatDuration(currPos));
            mSeekBar.setProgress(currPos);
        }
    }

