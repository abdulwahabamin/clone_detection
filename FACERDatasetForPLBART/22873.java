    /**
     * Restoreã?—ã?¦ã??ã?Ÿã‚„ã?¤ã?‹ã‚‰ {@link PlayPauseButton.SavedState}
     * ã‚’å?–å¾—ã?—çŠ¶æ³?ã‚’ã‚»ãƒƒãƒˆã?™ã‚‹
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

