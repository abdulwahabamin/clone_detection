    /**
     * {@inheritDoc}
     */
    @Override
    public void execute()
            throws InsufficientPermissionsException, NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Creating file: %s", this.mPath)); //$NON-NLS-1$
        }

        File f = new File(this.mPath);
        try {
            // Check that if the path exist, it need to be a file. Otherwise something is
            // wrong
            if (f.exists() && !f.isFile()) {
                if (isTrace()) {
                    Log.v(TAG, "Result: FAIL. ExecutionException"); //$NON-NLS-1$
                }
                throw new ExecutionException("the path exists but is not a file"); //$NON-NLS-1$
            }

            // Only create the file if the file not exists. Otherwise createNewFile
            // will return false
            if (!f.exists()) {
                if (!f.createNewFile()) {
                    if (isTrace()) {
                        Log.v(TAG, "Result: FAIL. InsufficientPermissionsException"); //$NON-NLS-1$
                    }
                    throw new InsufficientPermissionsException();
                }
            }
        } catch (IOException ioe) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. InsufficientPermissionsException"); //$NON-NLS-1$
            }
            throw new InsufficientPermissionsException();
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

