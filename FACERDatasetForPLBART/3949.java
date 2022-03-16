    @Override
    public ViewPropertyAnimator rotationY(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotationY(value);
        }
        return this;
    }

