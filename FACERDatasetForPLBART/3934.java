    @Override
    public long getDuration() {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            return n.getDuration();
        }
        return RETURN_WHEN_NULL;
    }

