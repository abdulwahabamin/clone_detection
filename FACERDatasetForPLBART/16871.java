    @Override
    protected void onStart() {
        super.onStart();
        FireLog.d(TAG, "(++) onStart");

        controlsFragment = (PlaybackControlsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_playback_controls);
        if (controlsFragment == null) {
            throw new IllegalStateException("Missing fragment with id 'controls'. Cannot continue.");
        }

        hidePlaybackControls();

//      mediaBrowser.connect();

        try {
            connectToSession(mediaBrowser.getSessionToken());
        } catch (IllegalStateException | RemoteException e) {
            FireLog.e(TAG, "could not connect media controller");
            hidePlaybackControls();
        }
    }

