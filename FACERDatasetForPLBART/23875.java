    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind() entry.");
        resetToInitialState();
        return false;
    }

