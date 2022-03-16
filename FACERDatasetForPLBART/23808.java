    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy() entry.");

        savePreferences();
        stopService(playIntent);
        if (musicSrv != null) {
            unbindService(musicConnection);
        }
        musicSrv = null;
        super.onDestroy();
    }

