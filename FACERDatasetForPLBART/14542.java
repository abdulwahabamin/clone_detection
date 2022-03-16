    /**
     * @return current time
     */
    private long refreshNow() {
        if (MusicUtils.mService == null)
            return 500;
        try {
            long pos = mPosOverride < 0 ? MusicUtils.mService.position() : mPosOverride;
            long remaining = 1000 - (pos % 1000);
            if ((pos >= 0) && (mDuration > 0)) {
                mCurrentTime.setText(MusicUtils.makeTimeString(getActivity(), pos / 1000));

                if (MusicUtils.mService.isPlaying()) {
                    mCurrentTime.setVisibility(View.VISIBLE);
                    mCurrentTime.setTextColor(getResources().getColor(R.color.transparent_black));
                    // Theme chooser
                    ThemeUtils.setTextColor(getActivity(), mCurrentTime, "audio_player_text_color");
                } else {
                    // blink the counter
                    int col = mCurrentTime.getCurrentTextColor();
                    mCurrentTime.setTextColor(col == getResources().getColor(
                            R.color.transparent_black) ? getResources().getColor(
                            R.color.holo_blue_dark) : getResources().getColor(
                            R.color.transparent_black));
                    remaining = 500;
                    // Theme chooser
                    ThemeUtils.setTextColor(getActivity(), mCurrentTime, "audio_player_text_color");
                }

                mProgress.setProgress((int)(1000 * pos / mDuration));
            } else {
                mCurrentTime.setText("--:--");
                mProgress.setProgress(1000);
            }
            return remaining;
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return 500;
    }

