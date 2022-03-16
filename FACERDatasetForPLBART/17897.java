    @Override
    public void onShuffleButtonClick() {

        Log.w(TAG, "shuffle mode got on click="
                +mMediaBrowserManager.getMediaController().isShuffleModeEnabled());

        if (mMediaBrowserManager.getMediaController().isShuffleModeEnabled()) {
            mMediaBrowserManager
                    .getMediaController()
                    .getTransportControls()
                    .setShuffleModeEnabled(false);
        } else {
            mMediaBrowserManager
                    .getMediaController()
                    .getTransportControls()
                    .setShuffleModeEnabled(true);
        }
    }

