    @Override
    public ViewPropertyAnimator rotationYBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotationYBy(value);
        }
        return this;
    }

