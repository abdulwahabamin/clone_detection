    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("deprecation")
    public void execute() throws NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Listing %s. Mode: %s", //$NON-NLS-1$
                            this.mSrc, this.mMode));
        }

        TFile f = getConsole().buildRealFile(mSrc);
        boolean isSecureStorage = SecureConsole.isSecureStorageDir(f);
        File javaFile = f.getFile();
        if (!isSecureStorage && !f.exists()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. NoSuchFileOrDirectory"); //$NON-NLS-1$
            }
            throw new NoSuchFileOrDirectory(this.mSrc);
        }
        if (this.mMode.compareTo(LIST_MODE.DIRECTORY) == 0) {
            // List files in directory
            TFile[] files = f.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    FileSystemObject fso = FileHelper.createFileSystemObject(files[i]);
                    if (fso != null) {
                        // Convert to virtual
                        fso.setParent(getConsole().buildVirtualPath(files[i].getParentFile()));
                        fso.setSecure(true);

                        if (isTrace()) {
                            Log.v(TAG, String.valueOf(fso));
                        }
                        this.mFiles.add(fso);
                    }
                }
            }

            //Now if not is the root directory, add the parent directory
            if (this.mSrc.compareTo(FileHelper.ROOT_DIRECTORY) != 0 &&
                    this.mMode.compareTo(LIST_MODE.DIRECTORY) == 0) {
                this.mFiles.add(0, new ParentDirectory(new File(this.mSrc).getParent()));
            }
        } else {
            // Build the source file information
            FileSystemObject fso = FileHelper.createFileSystemObject(
                    isSecureStorage ? javaFile : f);
            if (fso != null) {
                // Convert to virtual
                if (isSecureStorage) {
                    File virtualMountPoint = getConsole().getVirtualMountPoint();
                    fso = new Directory(
                            virtualMountPoint.getName(),
                            getConsole().getVirtualMountPoint().getParent(),
                            fso.getUser(), fso.getGroup(), fso.getPermissions(),
                            fso.getLastAccessedTime(),
                            fso.getLastModifiedTime(),
                            fso.getLastChangedTime());
                    fso.setSecure(true);
                } else {
                    fso.setParent(getConsole().buildVirtualPath(f.getParentFile()));
                }
                fso.setSecure(true);
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

