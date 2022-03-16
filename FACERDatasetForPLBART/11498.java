    /**
     * {@inheritDoc}
     */
    @Override
    public void execute()
            throws InsufficientPermissionsException, NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Resolving link of %s", //$NON-NLS-1$
                            this.mSrc));
        }

        File f = new File(this.mSrc);
        if (!f.exists()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. InsufficientPermissionsException"); //$NON-NLS-1$
            }
            throw new InsufficientPermissionsException();
        }
        try {
            String absPath = f.getCanonicalPath();
            ListCommand cmd = new ListCommand(absPath, LIST_MODE.FILEINFO);
            cmd.execute();
            this.mFso = cmd.getSingleResult();
        } catch (Exception e) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. ExecutionException"); //$NON-NLS-1$
            }
            throw new ExecutionException("can't resolve link"); //$NON-NLS-1$
        }

        if (isTrace()) {
            Log.v(TAG,
                    String.format("Link: %s", //$NON-NLS-1$
                            this.mFso));
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

