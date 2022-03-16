    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() entry.");
        savePreferences();
        super.onStop();
    }

