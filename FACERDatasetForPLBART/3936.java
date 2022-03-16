    @Override
    public long getStartDelay() {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            return n.getStartDelay();
        }
        return RETURN_WHEN_NULL;
    }

