    /**
     * Stops the seekbar strobe effect.
     */
    private void stopSeekbarStrobeEffect() {
        mSeekbarStrobeAnim = new AlphaAnimation(mSeekbar.getAlpha(), 1.0f);
        mSeekbarStrobeAnim.setDuration(700);
        mSeekbar.startAnimation(mSeekbarStrobeAnim);
        
    }

