    /**
     * å›žè»¢çŠ¶æ³?ã‚’ {@link PlayPauseButton.SavedState} ã?«ä¿?å­˜ã?™ã‚‹
     * {@inheritDoc}
     */
    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState savedState = new SavedState(superState);
        savedState.played = isPlayed();
        return savedState;
    }

