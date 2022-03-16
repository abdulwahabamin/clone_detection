    /**
     * Restore�?��?��??�?�や�?��?�ら {@link PlayPauseButton.SavedState}
     * を�?�得�?�状�?をセット�?�る
     * {@inheritDoc}
     */
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        setPlayed(savedState.played);
        setUpAnimator();
        invalidate();
    }

