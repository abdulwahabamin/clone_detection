    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy() entry.");
        resetToInitialState();
        stopForeground(true);
        super.onDestroy();
    }

