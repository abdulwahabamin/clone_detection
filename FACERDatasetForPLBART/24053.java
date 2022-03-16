    private void scheduleFadeOut() {
        int fadeOutSeconds = Integer.parseInt(mSettings.getString(SettingsActivity.FADE_SECONDS, "0"));
        boolean crossFade = mSettings.getBoolean(SettingsActivity.CROSS_FADE, false);

        if (fadeOutSeconds > 0) {
            long timeLeftMillis = mPlayers[mCurrentPlayer].duration() - mPlayers[mCurrentPlayer].currentPosition();
            if (timeLeftMillis > 0) {
                long delayMillis = timeLeftMillis - fadeOutSeconds * 1000;
                Log.d(TAG, "Scheduling fade out " + fadeOutSeconds + " seconds with cross-fade=" + crossFade + " in " + delayMillis + " ms");
                if (crossFade) {
                    mPlaybackHander.sendEmptyMessageDelayed(CROSSFADE, delayMillis);
                }
                mPlaybackHander.sendMessageDelayed(mPlaybackHander.obtainMessage(FADEDOWN, mCurrentPlayer, 0), delayMillis);
            } else {
                Log.w(TAG, "timeLeft is " + timeLeftMillis + " ms");
            }
        }
    }

