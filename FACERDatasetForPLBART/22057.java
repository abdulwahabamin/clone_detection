    public void goToPosition(int pos) {
        synchronized (this) {
            if (mPlaylist.size() <= 0) {
                if (D) Log.d(TAG, "No play queue");
                scheduleDelayedShutdown();
                return;
            }
            if (pos < 0) {
                return;
            }
            if (pos == mPlayPos) {
                if (!isPlaying()) {
                    play();
                }
                return;
            }
            stop(false);
            setAndRecordPlayPos(pos);
            openCurrentAndNext();
            play();
            notifyChange(META_CHANGED);
        }
    }

