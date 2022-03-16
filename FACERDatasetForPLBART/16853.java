    @Override
    public void onStop() {
        super.onStop();
        if (mediaBrowser != null) {
            mediaBrowser.disconnect();
        }

        if (MediaControllerCompat.getMediaController(NowPlayingActivity.this) != null) {
            MediaControllerCompat.getMediaController(NowPlayingActivity.this).unregisterCallback(mediaControllerCallback);
        }
    }

