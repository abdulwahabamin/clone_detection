    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean cancel() {
        //Is't cancellable by definition?
        if (!isCancellable()) {
            return false;
        }

        //Stop the thread
        synchronized (this.mSync) {
            if (this.mWorkerThread != null) {
                this.mWorkerThread.mAlive = false;
                this.mSync.notify();
            }
        }

        //Notify cancellation
        if (this.mOnCancelListener != null) {
            this.mCancelled = this.mOnCancelListener.onCancel();
            return this.mCancelled;
        }
        return false;
    }

