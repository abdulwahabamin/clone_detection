    /**
     * {@inheritDoc}
     */
    @Override
    public final void onAsyncExitCode(int exitCode) {
        boolean notify = false;
        synchronized (mSync) {
            if (mRefs <= 0) {
                notify = true;
            }
            mStartNotified = true;
        }
        if (notify) {
            onConcurrentAsyncExitCode(exitCode);
        }
    }

