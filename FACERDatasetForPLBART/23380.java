    public void openAsync(String path) {
        synchronized (this) {
            if (path == null) {
                return;
            }
            
            mRepeatMode = REPEAT_NONE;
            ensurePlayListCapacity(1);
            mPlayListLen = 1;
            mPlayPos = -1;
            
            mFileToPlay = path;
            mCursor = null;
            mPlayer.setDataSourceAsync(mFileToPlay);
            mOneShot = true;
        }
    }

