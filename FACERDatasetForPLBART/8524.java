    /**
     * {@inheritDoc}
     */
    @Override
    public final void onAsyncEnd(boolean cancelled) {
        boolean notify = false;
        if (cancelled) {
            mCancelled = true;
        }
        synchronized (mSync) {
            if (mRefs <= 1) {
                notify = true;
            }
            mRefs--;
            mStartNotified = true;
        }
        if (notify) {
            onConcurrentAsyncEnd(mCancelled);
        }
    }

