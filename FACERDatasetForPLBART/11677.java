    /**
     * Method that communicates that partial result is ended and no new result
     * will be received.
     *
     * @param cancelled If the program was cancelled
     * @hide
     */
    public final void onRequestEndParsePartialResult(boolean cancelled) {
        synchronized (this.mSync) {
            if (this.mWorkerThread != null) {
                this.mWorkerThread.mAlive = false;
                this.mSync.notify();
            }
        }

        try {
            this.mWorkerThread.join();
        } catch (InterruptedException e) {
            // Ignore this.
        }

        //Notify end to command class
        this.onEndParsePartialResult(cancelled);

        //If a listener is defined, then send the start event
        if (getAsyncResultListener() != null) {
            getAsyncResultListener().onAsyncEnd(cancelled);
        }
    }

