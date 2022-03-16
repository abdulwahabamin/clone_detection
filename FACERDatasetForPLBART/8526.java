    /**
     * {@inheritDoc}
     */
    @Override
    public final void onPartialResult(Object result) {
        synchronized (mSync) {
            if (!mCancelled && mRefs >= 1) {
                onConcurrentPartialResult(result);
            }
        }
    }

