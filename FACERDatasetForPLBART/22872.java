    /**
     * 回転状�?を {@link PlayPauseButton.SavedState} �?��?存�?�る
     * {@inheritDoc}
     */
    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState savedState = new SavedState(superState);
        savedState.played = isPlayed();
        return savedState;
    }

