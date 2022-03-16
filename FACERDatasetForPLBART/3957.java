    @Override
    public ViewPropertyAnimator scaleY(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.scaleY(value);
        }
        return this;
    }

