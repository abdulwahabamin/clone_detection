    @Override
    public synchronized void setCallback(Callback callback) {
        // if preparing we can't do anything
        if (isPreparing()) {
            Log.w(TAG, "setCallback:player is preparing");
            return;
        }

        this.mCallback = callback;
    }

