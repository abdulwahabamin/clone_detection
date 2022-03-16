        @Override
        public void onSetRepeatMode(int repeatMode) {
            Log.d(TAG, "onSetRepeatMode:called");
            Log.i(TAG, "onSetRepeatMode:repeatMode="+repeatMode);
            if (setRepeatMode(repeatMode)) {
                mServiceCallback.onRepeatModeChanged(repeatMode);
            }
        }

