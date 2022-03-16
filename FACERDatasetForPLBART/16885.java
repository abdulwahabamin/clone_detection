    @Override
    protected void onStop() {
        super.onStop();
        FireLog.d(TAG, "onStop");

        if (MediaControllerCompat.getMediaController(this) != null) {
            MediaControllerCompat.getMediaController(this).unregisterCallback(mediaControllerCallback);
        }
    }

