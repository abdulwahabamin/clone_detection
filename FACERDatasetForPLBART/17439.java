    private void registerAudioNoisyReceiver() {
        Log.d(TAG, "registerAudioNoisyReceiver:called");
        Log.i(TAG, "registerAudioNoisyReceiver:state="+Playback.states[mState]);
        if (!mAudioNoisyReceiverRegistered) {
            Log.i(TAG, "registerAudioNoisyReceiver:registered");
            mContext.registerReceiver(mAudioNoisyReceiver, mAudioNoisyIntentFilter);
            mAudioNoisyReceiverRegistered = true;
        }
    }

