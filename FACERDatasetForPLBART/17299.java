        @Override
        public void onSkipToNext() {
            if (mQueueManager.isLastItemPlaying()) {
                if (mRepeatMode == PlaybackStateCompat.REPEAT_MODE_ALL) {
                    mQueueManager.skipQueuePosition(1);
                }
            } else {
                mQueueManager.skipQueuePosition(1);
            }
            handlePlayRequest();
        }

