    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Creating directory: %s", this.mPath)); //$NON-NLS-1$
        }

        TFile f = getConsole().buildRealFile(this.mPath);
        // Check that if the path exist, it need to be a directory. Otherwise something is
        // wrong
        if (f.exists() && !f.isDirectory()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. ExecutionException"); //$NON-NLS-1$
            }
            throw new ExecutionException("the path exists but is not a folder"); //$NON-NLS-1$
        }

        // Only create the directory if the folder not exists. Otherwise mkdir will return false
        if (!f.exists()) {
            if (!f.mkdir()) {
                if (isTrace()) {
                    Log.v(TAG, "Result: FAIL. IOException"); //$NON-NLS-1$
                }
                throw new ExecutionException("Failed to create directory");
            }
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

