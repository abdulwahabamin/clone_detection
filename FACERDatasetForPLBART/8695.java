    /**
     * {@inheritDoc}
     */
    @Override
    public void execute()
            throws InsufficientPermissionsException, NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Getting parent directory of %s", //$NON-NLS-1$
                            this.mSrc));
        }

        File f = new File(this.mSrc);
        this.mParentDir = f.getParent();

        if (isTrace()) {
            Log.v(TAG,
                    String.format("Parent directory: %S", //$NON-NLS-1$
                            this.mParentDir));
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

