        @Override
        public void onSetShuffleModeEnabled(boolean enabled) {
            Log.d(TAG, "onSetShuffleModeEnabled:called");
            Log.d(TAG, "onSetShuffleModeEnabled:enabled="+enabled);
            int mode = 0;
            if (enabled) {
                mode = 1;
            }

            if (setShuffleMode(mode)) {
                if (mQueueManager.getCurrentMusic() != null) {
                    if (enabled) {
                        mQueueManager.shuffleMusic(mQueueManager.getCurrentMusicMediaId());
                    } else {
                        Log.w(TAG, "onSetShuffleModeEnabled:cur="+mQueueManager.getCurrentMusicMediaId());
                        mQueueManager.setQueueFromMediaId(
                                mQueueManager.getCurrentMusicMediaId(), true);
                    }
                }
                mServiceCallback.onShuffleModeChanged(mode);
            }
        }

