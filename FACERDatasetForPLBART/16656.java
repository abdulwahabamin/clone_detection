        @Override
        public void onPlayFromMediaId(String mediaId, Bundle extras) {
            FireLog.d(TAG, "(++) onPlayFromMediaId mediaId:" + mediaId + "  extras=" + extras);
            queueManager.setQueueFromMusic(mediaId);
            handlePlayRequest();
        }

