        @Override
        public void onSkipToPrevious() {
            FireLog.d(TAG, "(++) onSkipToPrevious");
            if (queueManager.skipQueuePosition(-1)) {
                handlePlayRequest();
            } else {
                handleStopRequest("Cannot skip");
            }
            queueManager.updateMetadata();
        }

