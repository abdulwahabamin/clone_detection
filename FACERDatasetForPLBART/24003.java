    private void prepareAndPlay(long audioId) {
        if (prepare(audioId)) {
            fetchMetadata(audioId);
            play();
            notifyChange(META_CHANGED);
        } else {
            Toast.makeText(this, R.string.playback_failed, Toast.LENGTH_SHORT).show();
        }
    }

