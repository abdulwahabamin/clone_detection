    /**
     * {@inheritDoc}
     */
    @Override
    public final void onAsyncStart() {
        boolean notify = false;
        synchronized (mSync) {
            if (!mStartNotified) {
                notify = true;
            }
            mStartNotified = true;
        }
        if (notify) {
            onConcurrentAsyncStart();
        }
    }

