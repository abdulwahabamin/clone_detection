    public void setRepeatMode(int repeatmode) {
        synchronized (this) {
            mRepeatMode = repeatmode;
            setNextTrack();
            notifyChange(REPEATMODE_CHANGED);
            saveQueue(false);
        }
    }

