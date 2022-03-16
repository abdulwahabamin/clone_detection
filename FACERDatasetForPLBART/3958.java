    @Override
    public ViewPropertyAnimator scaleYBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.scaleYBy(value);
        }
        return this;
    }

