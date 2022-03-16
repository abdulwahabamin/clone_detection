    /**
     * {@inheritDoc}
     */
    @Override
    public void execute()
            throws InsufficientPermissionsException, NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Finding in %s the query %s", //$NON-NLS-1$
                            this.mDirectory, Arrays.toString(this.mQueryRegExp)));
        }
        if (this.mAsyncResultListener != null) {
            this.mAsyncResultListener.onAsyncStart();
        }

        boolean ready = true;
        File f = new File(this.mDirectory);
        if (!f.exists()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. NoSuchFileOrDirectory"); //$NON-NLS-1$
            }
            ready = false;
        }
        if (ready && !f.isDirectory()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. NoSuchFileOrDirectory"); //$NON-NLS-1$
            }
            ready = false;
        }

        // Find the data
        if (ready) {
            findRecursive(f);
        }

        // record program's execution termination
        synchronized (mSync) {
            mEnded = true;
            // account for the delay between the end of findRecursive and setting program
            // termination flag (mEnded)
            // notify again in case a thread entered wait state since
            mSync.notify();
        }

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

