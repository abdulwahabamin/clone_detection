    @Override
    public void onCompletion() {
        // handle according to repeat mode
        switch (mRepeatMode) {
            case PlaybackStateCompat.REPEAT_MODE_ONE:
                handlePlayRequest();
                break;
            case PlaybackStateCompat.REPEAT_MODE_NONE:
                if (mQueueManager.isLastItemPlaying()) {
                    updatePlaybackState(null);
                } else {
                    mQueueManager.skipQueuePosition(1);
                    handlePlayRequest();
                }
                break;
            case PlaybackStateCompat.REPEAT_MODE_ALL:
                mQueueManager.skipQueuePosition(1);
                handlePlayRequest();
                break;
        }
    }

