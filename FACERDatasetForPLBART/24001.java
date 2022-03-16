    private void updatePlaylist() {
        if (mPlayListLen == 0) {
            resetMetadata();
            notifyChange(META_CHANGED);
        }
        notifyChange(QUEUE_CHANGED);
    }

