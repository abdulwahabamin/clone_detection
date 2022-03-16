    @Override
    public ViewPropertyAnimator rotation(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotation(value);
        }
        return this;
    }

