    @Override
    public ViewPropertyAnimator translationXBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.translationXBy(value);
        }
        return this;
    }

