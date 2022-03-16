    @Override
    public void jumpToCurrentState() {
        Log.v(TAG, "jumpToCurrentState()");
        if (animator != null) {
            animator.cancel();
        }
        setProgress(isPlay ? 1.0F : 0.0F);
    }

