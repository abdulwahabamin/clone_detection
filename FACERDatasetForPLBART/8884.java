    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws NoSuchFileOrDirectory, ExecutionException {
        synchronized (this.mSync) {
            this.mReady = true;
            this.mSync.notify();
        }

        if (isTrace()) {
            Log.v(TAG,
                    String.format("Writing file %s", this.mFile)); //$NON-NLS-1$

        }
        if (this.mAsyncResultListener != null) {
            this.mAsyncResultListener.onAsyncStart();
        }

        // Wait the finalization
        try {
            synchronized (this.mSync) {
                this.mSync.wait();
            }
        } catch (Throwable _throw) {/**NON BLOCK**/}

        if (this.mAsyncResultListener != null) {
            this.mAsyncResultListener.onAsyncEnd(this.mCancelled);
        }
        if (this.mAsyncResultListener != null) {
            this.mAsyncResultListener.onAsyncExitCode(0);
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

