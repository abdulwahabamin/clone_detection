    /**
     * Initiates the strobe effect on the seekbar.
     */
    private void initSeekbarStrobeEffect() {
        mSeekbarStrobeAnim = new AlphaAnimation(1.0f, 0.0f);
        mSeekbarStrobeAnim.setRepeatCount(SEEKBAR_STROBE_ANIM_REPEAT);
        mSeekbarStrobeAnim.setDuration(700);
        mSeekbarStrobeAnim.setRepeatMode(Animation.REVERSE);

        mSeekbar.startAnimation(mSeekbarStrobeAnim);

    }

