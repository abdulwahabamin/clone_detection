        @Override
        public void onSkipToNext() {
            FireLog.d(TAG, "(++) onSkipToNext");
            if (queueManager.skipQueuePosition(1)) {
                handlePlayRequest();
            } else {
                handleStopRequest("Cannot skip");
            }
            queueManager.updateMetadata();
        }

