    @Override
    public ViewPropertyAnimator alphaBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.alphaBy(value);
        }
        return this;
    }

