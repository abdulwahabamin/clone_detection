    public void onConnected() {
        FireLog.d(TAG, "onConnected");
        MediaControllerCompat controller = MediaControllerCompat.getMediaController(this);
        if (controller != null) {
            MediaCategoryActivity.this.onMetadataChanged(controller.getMetadata());
            controller.registerCallback(mediaControllerCallback);
        }
    }

