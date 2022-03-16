    @Override
    public void start() {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.start();
        }
    }

