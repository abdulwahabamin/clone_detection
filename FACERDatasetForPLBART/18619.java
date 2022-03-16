    /**
     * Helper method that checks whether the audio playback service
     * is running or not.
     */
    private void checkServiceRunning() {
        if (mApp.isServiceRunning() && mApp.getService().getCursor()!=null) {
            initMiniPlayer();
            setPlayPauseButton();
            initListViewAdapter(mInitListViewParams);
        } else {
            showEmptyTextView();
        }

    }

