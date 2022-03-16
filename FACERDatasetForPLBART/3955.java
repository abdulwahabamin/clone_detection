    @Override
    public ViewPropertyAnimator scaleX(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.scaleX(value);
        }
        return this;
    }

