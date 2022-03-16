    /**
     * Changes MTU.
     * This will trigger onMtuChanged() callback
     * @param size
     */
    public void changeMtu(int size){
        if (!mConnectedGatt.requestMtu(size)) {
            Log.d(TAG,"Couldn't set MTU!!");
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mBleChatEvents.onConnectionError("Couldn't set MTU!!");
                }
            });
            return;
        }
        Log.d(TAG, "MTU set to " + size);
    }

