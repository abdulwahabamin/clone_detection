        @Override
        public void onPlayFromMediaId(String mediaId, Bundle extras) {
            Log.d(TAG, "onPlayFromMediaId:called");
            Log.d(TAG, "onPlayFromMediaId:mediaId="+mediaId);
            Log.d(TAG, "onPlayFromMediaId:bundle="+extras);

            mQueueManager.setQueueFromMediaId(mediaId);
            if (mShuffleMode==1) {
                mQueueManager.shuffleMusic(mQueueManager.getCurrentMusicMediaId());
            }
            handlePlayRequest();
        }

