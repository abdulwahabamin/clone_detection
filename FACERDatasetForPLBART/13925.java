    @Override
    protected void onStop() {
        // Unbind
        if (MusicUtils.mService != null) {
            MusicUtils.unbindFromService(mToken);
            mToken = null;
        }

        unregisterReceiver(mMediaStatusReceiver);
        super.onStop();
    }

