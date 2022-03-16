    @Override
    public ViewPropertyAnimator scaleXBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.scaleXBy(value);
        }
        return this;
    }

