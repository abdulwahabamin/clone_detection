    @Override
    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.setInterpolator(interpolator);
        }
        return this;
    }

