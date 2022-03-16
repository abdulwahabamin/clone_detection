    /**
     * {@inheritDoc}
     */
    @Override
    public void execute()
            throws InsufficientPermissionsException, NoSuchFileOrDirectory, ExecutionException,
                   CancelledOperationException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Creating from %s to %s", this.mSrc, this.mDst)); //$NON-NLS-1$
        }

        File s = new File(this.mSrc);
        File d = new File(this.mDst);
        if (!s.exists()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. NoSuchFileOrDirectory"); //$NON-NLS-1$
            }
            throw new NoSuchFileOrDirectory(this.mSrc);
        }

        //Move or copy recursively
        if (d.exists()) {
            if (!FileHelper.copyRecursive(s, d, this)) {
                if (isTrace()) {
                    Log.v(TAG, "Result: FAIL. InsufficientPermissionsException"); //$NON-NLS-1$
                }
                throw new InsufficientPermissionsException();
            }
            if (!FileHelper.deleteFolder(s)) {
                if (isTrace()) {
                    Log.v(TAG, "Result: OK. WARNING. Source not deleted."); //$NON-NLS-1$
                }
            }
        } else {
            // Move between filesystem is not allow. If rename fails then use copy operation
            if (!s.renameTo(d)) {
                if (!FileHelper.copyRecursive(s, d, this)) {
                    if (isTrace()) {
                        Log.v(TAG, "Result: FAIL. InsufficientPermissionsException"); //$NON-NLS-1$
                    }
                    throw new InsufficientPermissionsException();
                }
                if (!FileHelper.deleteFolder(s)) {
                    if (isTrace()) {
                        Log.v(TAG, "Result: OK. WARNING. Source not deleted."); //$NON-NLS-1$
                    }
                }
            }
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

