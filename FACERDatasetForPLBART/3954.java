    @Override
    public ViewPropertyAnimator translationYBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.translationYBy(value);
        }
        return this;
    }

