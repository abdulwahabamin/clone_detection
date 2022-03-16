    public void onConnected() {
        FireLog.d(TAG, "(++) onConnected");
        MediaControllerCompat controller = MediaControllerCompat.getMediaController(getActivity());
        if (controller != null) {
            PlaybackControlsFragment.this.onPlaybackStateChanged(controller.getPlaybackState());
            PlaybackControlsFragment.this.onMetadataChanged(controller.getMetadata());
            FireLog.d(TAG, "Register callback=" + mediaControllerCallback);
            controller.registerCallback(mediaControllerCallback);
        }
    }

