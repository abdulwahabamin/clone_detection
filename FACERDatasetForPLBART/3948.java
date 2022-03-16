    @Override
    public ViewPropertyAnimator rotationXBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotationXBy(value);
        }
        return this;
    }

