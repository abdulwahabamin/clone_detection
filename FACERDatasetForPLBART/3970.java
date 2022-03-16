    @Override
    public ViewPropertyAnimator setInterpolator(/*Time*/Interpolator interpolator) {
        mInterpolatorSet = true;
        mInterpolator = interpolator;
        return this;
    }

