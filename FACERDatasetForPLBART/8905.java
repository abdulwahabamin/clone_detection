    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean end() {
        // Internally this method do the same things that cancel method, but invokes
        // onEnd instead of onCancel

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

        //Notify ending
        SIGNAL signal = onRequestEnd();
        if (this.mOnEndListener != null) {
            if (signal == null) {
                this.mCancelled = this.mOnEndListener.onEnd();
            } else {
                this.mCancelled = this.mOnEndListener.onSendSignal(signal);
            }
            return this.mCancelled;
        }
        return false;
    }

