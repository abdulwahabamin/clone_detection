    @Override
    protected void onPause() {
        super.onPause();
        if (playServicesAvailable) {
            mSessionManager.removeSessionManagerListener(mSessionManagerListener);
            mCastSession = null;
        }
    }

