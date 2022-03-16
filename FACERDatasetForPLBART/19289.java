    /**
     * Sets the play/pause button states.
     */
    private void setPlayPauseButton() {
        if (mApp.isServiceRunning()) {
            if (mApp.getService().isPlayingMusic()) {
                animatePlayToPause();
                stopSeekbarStrobeEffect();
            } else {
                animatePauseToPlay();
                initSeekbarStrobeEffect();
            }

        }

    }

