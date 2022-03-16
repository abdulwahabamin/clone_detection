    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Getting parent directory of %s", //$NON-NLS-1$
                            this.mSrc));
        }

        // Build the source file information
        TFile f = getConsole().buildRealFile(mSrc).getParentFile();
        boolean isSecureStorage = SecureConsole.isSecureStorageDir(f);
        if (isSecureStorage) {
            this.mParentDir = getConsole().getVirtualMountPoint().getAbsolutePath();
        } else {
            this.mParentDir = getConsole().buildVirtualPath(f);
        }

        if (isTrace()) {
            Log.v(TAG,
                    String.format("Parent directory: %S", //$NON-NLS-1$
                            this.mParentDir));
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

