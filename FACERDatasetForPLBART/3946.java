    @Override
    public ViewPropertyAnimator rotationBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotationBy(value);
        }
        return this;
    }

