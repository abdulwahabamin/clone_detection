    @Override
    public ViewPropertyAnimator x(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.x(value);
        }
        return this;
    }

