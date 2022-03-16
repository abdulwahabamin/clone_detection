    /**
     * {@inheritDoc}
     */
    @Override
    public void execute()
            throws InsufficientPermissionsException, NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Listing %s. Mode: %s", //$NON-NLS-1$
                            this.mSrc, this.mMode));
        }

        File f = new File(this.mSrc);
        if (!f.exists()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. NoSuchFileOrDirectory"); //$NON-NLS-1$
            }
            throw new NoSuchFileOrDirectory(this.mSrc);
        }
        if (this.mMode.compareTo(LIST_MODE.DIRECTORY) == 0) {
            File[] files = f.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    FileSystemObject fso = FileHelper.createFileSystemObject(files[i]);
                    if (fso != null) {
                        if (isTrace()) {
                            Log.v(TAG, String.valueOf(fso));
                        }
                        this.mFiles.add(fso);
                    }
                }
            }

            //Now if not is the root directory
            if (this.mSrc != null &&
                    this.mSrc.compareTo(FileHelper.ROOT_DIRECTORY) != 0 &&
                    this.mMode.compareTo(LIST_MODE.DIRECTORY) == 0) {
                this.mFiles.add(0, new ParentDirectory(new File(this.mSrc).getParent()));
            }

        } else {
            // Build the parent information
            FileSystemObject fso = FileHelper.createFileSystemObject(f);
            if (fso != null) {
                if (isTrace()) {
                    Log.v(TAG, String.valueOf(fso));
                }
                this.mFiles.add(fso);
            }
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

