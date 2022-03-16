    @Override
    public ViewPropertyAnimator xBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.xBy(value);
        }
        return this;
    }

