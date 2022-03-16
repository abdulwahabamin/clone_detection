    @Override
    protected void onStop() {
        // Unbind
        if (MusicUtils.mService != null)
            MusicUtils.unbindFromService(mToken);
        unregisterReceiver(mMediaStatusReceiver);
        super.onStop();
    }

