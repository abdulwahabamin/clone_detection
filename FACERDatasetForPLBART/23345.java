    private long refreshNow() {
        if(mService == null)
            return 500;
        try {
            if (mFirstRefreshEvent == false) {
                mSkipSeek = false;
            }
            if (mFirstRefreshEvent == true) {
                mFirstRefreshEvent = false;
            }
            long pos = mPosOverride < 0 ? mService.position() : mPosOverride;
            long remaining = 1000 - (pos % 1000);
            if ((pos >= 0) && (mDuration > 0)) {
                mCurrentTime.setText(MusicUtils.makeTimeString(this, (pos + 500) / 1000));

                if (mService.isPlaying()) {
                    mCurrentTime.setVisibility(View.VISIBLE);
                } else {
                    // blink the counter
                    int vis = mCurrentTime.getVisibility();
                    mCurrentTime.setVisibility(vis == View.INVISIBLE ? View.VISIBLE : View.INVISIBLE);
                    remaining = 500;
                }

                mProgress.setProgress((int) (1000 * pos / mDuration));
            } else {
                // Enabling blink counter at the end of playback
                int vis = mCurrentTime.getVisibility();
                mCurrentTime.setVisibility(vis == View.INVISIBLE ? View.VISIBLE : View.INVISIBLE);
                remaining = 500;
                mProgress.setProgress(1000);
            }
            // return the number of milliseconds until the next full second, so
            // the counter can be updated at just the right time
            return remaining;
        } catch (RemoteException ex) {
        }
        return 500;
    }

