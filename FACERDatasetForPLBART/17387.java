    @Override
    public void onNotificationRequired() {
        Log.d(TAG, "onNotificationRequired:called");
        // start notification of not already
        mMediaNotificationManager.startNotification();
    }

