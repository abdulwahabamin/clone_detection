    @Override
    public void onStop() {
        paused = true;
        if (mService != null && mOneShot && getChangingConfigurations() == 0) {
            try {
                mService.stop();
            } catch (RemoteException ex) {
            }
        }
        mHandler.removeMessages(REFRESH);
        unregisterReceiver(mStatusListener);
        MusicUtils.unbindFromService(this);
        mService = null;
        super.onStop();
    }

