    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Deleting file: %s", this.mPath)); //$NON-NLS-1$
        }

        TFile f = getConsole().buildRealFile(this.mPath);
        if (!f.exists()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. NoSuchFileOrDirectory"); //$NON-NLS-1$
            }
            throw new NoSuchFileOrDirectory(this.mPath);
        }

        // Check that if the path exist, it need to be a file. Otherwise something is
        // wrong
        if (f.exists() && !f.isFile()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. ExecutionException"); //$NON-NLS-1$
            }
            throw new ExecutionException("the path exists but is not a file"); //$NON-NLS-1$
        }

        // Delete the file
        try {
            TFile.rm(f);
        } catch (IOException ex) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. IOException"); //$NON-NLS-1$
            }
            throw new ExecutionException("Failed to delete file", ex);
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

