    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws InsufficientPermissionsException,
        NoSuchFileOrDirectory, ExecutionException {

        if (isTrace()) {
            Log.v(TAG,
                    String.format("Calculating checksums of file %s", this.mSrc)); //$NON-NLS-1$
        }

        // Check that the file exists
        if (!this.mSrc.exists()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. NoSuchFileOrDirectory"); //$NON-NLS-1$
            }
            throw new NoSuchFileOrDirectory(this.mSrc.getAbsolutePath());
        }

        CHECKSUMS checksum = CHECKSUMS.MD5;
        try {
            if (this.mAsyncResultListener != null) {
                this.mAsyncResultListener.onAsyncStart();
            }

            // Calculate digests
            calculateDigest(checksum);
            checksum = CHECKSUMS.SHA1;
            calculateDigest(checksum);

            if (this.mAsyncResultListener != null) {
                this.mAsyncResultListener.onAsyncEnd(false);
            }
            if (this.mAsyncResultListener != null) {
                this.mAsyncResultListener.onAsyncExitCode(0);
            }

            if (isTrace()) {
                Log.v(TAG, "Result: OK"); //$NON-NLS-1$
            }

        } catch (InterruptedException ie) {
            if (this.mAsyncResultListener != null) {
                this.mAsyncResultListener.onAsyncEnd(true);
            }
            if (this.mAsyncResultListener != null) {
                this.mAsyncResultListener.onAsyncExitCode(143);
            }

            if (isTrace()) {
                Log.v(TAG, "Result: CANCELLED"); //$NON-NLS-1$
            }

        } catch (Exception e) {
            Log.e(TAG,
                    String.format(
                            "Fail to calculate %s checksum of file %s", //$NON-NLS-1$
                            checksum.name(),
                            this.mSrc.getAbsolutePath()),
                    e);
            if (this.mAsyncResultListener != null) {
                this.mAsyncResultListener.onException(e);
            }
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL"); //$NON-NLS-1$
            }
        }
    }

