    private void unregisterAudioNoisyReceiver() {
        Log.d(TAG, "unregisterAudioNoisyReceiver:called");
        Log.i(TAG, "unregisterAudioNoisyReceiver:state="+Playback.states[mState]);
        if (mAudioNoisyReceiverRegistered) {
            Log.i(TAG, "unregisterAudioNoisyReceiver:unregistered");
            mContext.unregisterReceiver(mAudioNoisyReceiver);
            mAudioNoisyReceiverRegistered = false;
        }
    }

