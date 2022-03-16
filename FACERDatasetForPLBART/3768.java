    @Override
    public void end() {
        if (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this)) {
            // Special case if the animation has not yet started; get it ready for ending
            mStartedDelay = false;
            startAnimation();
        } else if (!mInitialized) {
            initAnimation();
        }
        // The final value set on the target varies, depending on whether the animation
        // was supposed to repeat an odd number of times
        if (mRepeatCount > 0 && (mRepeatCount & 0x01) == 1) {
            animateValue(0f);
        } else {
            animateValue(1f);
        }
        endAnimation();
    }

