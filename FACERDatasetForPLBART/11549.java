    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws NoSuchFileOrDirectory, ExecutionException {

        if (isTrace()) {
            Log.v(TAG,
                    String.format("Creating file: %s", this.mPath)); //$NON-NLS-1$
        }

        TFile f = getConsole().buildRealFile(this.mPath);
        // Check that if the path exist, it need to be a file. Otherwise
        // something is wrong
        if (f.exists() && !f.isFile()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. ExecutionException"); //$NON-NLS-1$
            }
            throw new ExecutionException("the path exists but is not a file"); //$NON-NLS-1$
        }

        // Only create the file if the file not exists. Otherwise createNewFile
        // will return false
        if (!f.exists()) {
            try {
                if (!f.createNewFile()) {
                    if (isTrace()) {
                        Log.v(TAG, "Result: FAIL. ExecutionException"); //$NON-NLS-1$
                    }
                    throw new ExecutionException("Failed to create file");
                }
            } catch (IOException ex) {
                throw new ExecutionException("Failed to create file", ex);
            }
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

