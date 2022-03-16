    /**
     * @return true if successful, false if failed
     */
    public boolean prepare(String path) {
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setOnPreparedListener(null);
            if (path.startsWith("content://")) {
                mMediaPlayer.setDataSource(mContext, Uri.parse(path));
            } else {
                mMediaPlayer.setDataSource(path);
            }
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.prepare();
        } catch (IOException | IllegalArgumentException e) {
            Log.w(LOGTAG, "Couldn't open audio file: " + path, e);
            mIsInitialized = false;
            return false;
        }
        mMediaPlayer.setOnCompletionListener(listener);
        mMediaPlayer.setOnErrorListener(errorListener);

        Intent i = new Intent(AudioEffect.ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION);
        i.putExtra(AudioEffect.EXTRA_AUDIO_SESSION, getAudioSessionId());
        i.putExtra(AudioEffect.EXTRA_PACKAGE_NAME, mContext.getPackageName());
        mContext.sendBroadcast(i);

        Log.d(LOGTAG, "Prepared song: " + path);

        mIsInitialized = true;
        return true;
    }

