    /**
     * {@inheritDoc}
     */
    @Override
    public final void onException(Exception cause) {
        synchronized (mSync) {
            if (!mCancelled && mRefs >= 1) {
                onConcurrentException(cause);
            }
        }
    }

