    @Override
    public ViewPropertyAnimator yBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.yBy(value);
        }
        return this;
    }

