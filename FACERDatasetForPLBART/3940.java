    @Override
    public void cancel() {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.cancel();
        }
    }

