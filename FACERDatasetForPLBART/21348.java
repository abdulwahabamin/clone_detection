    @Override
    public void onResume() {
        if (playServicesAvailable) {
            mCastSession = mSessionManager.getCurrentCastSession();
            mSessionManager.addSessionManagerListener(mSessionManagerListener);
        }
        //For Android 8.0+: service may get destroyed if in background too long
        if (mService == null) {
            mToken = MusicPlayer.bindToService(this, this);
        }
        onMetaChanged();
        super.onResume();
    }

