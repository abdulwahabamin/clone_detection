    @Override
    public ViewPropertyAnimator rotationX(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotationX(value);
        }
        return this;
    }

