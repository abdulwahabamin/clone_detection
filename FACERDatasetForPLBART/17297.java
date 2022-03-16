        @Override
        public void onSkipToQueueItem(long id) {
            Log.d(TAG, "onSkipToQueueItem:called");
            Log.i(TAG, "onSkipToQueueItem: id="+id);
            mQueueManager.setCurrentQueueItem(id);
            handlePlayRequest();
        }

