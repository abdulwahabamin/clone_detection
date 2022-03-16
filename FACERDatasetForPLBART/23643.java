    @Override
    public void onPause() {
        if (MusicUtils.sService != null) {
            try {
                // This looks a little weird (when it's not playing, stop playing)
                // but it is correct. When nothing is playing, it means that this
                // was paused before a connection was established, in which case
                // we stop trying to connect/play.
                // Otherwise, this call to onPause() was a result of the call to
                // finish() above, and we should let playback continue.
                if (! MusicUtils.sService.isPlaying()) {
                    MusicUtils.sService.stop();
                }
            } catch (RemoteException ex) {
            }
        }
        unregisterReceiver(mStatusListener);
        MusicUtils.unbindFromService(this);
        super.onPause();
    }

