        @Override
        public void onSkipToQueueItem(long queueId) {
            FireLog.d(TAG, "(++) onSkipToQueueItem:" + queueId);
            queueManager.setCurrentQueueItem(queueId);
            queueManager.updateMetadata();
        }

