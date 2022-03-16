    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Creating from %s to %s", this.mSrc, this.mDst)); //$NON-NLS-1$
        }

        TFile s = getConsole().buildRealFile(this.mSrc);
        TFile d = getConsole().buildRealFile(this.mDst);
        if (!s.exists()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. NoSuchFileOrDirectory"); //$NON-NLS-1$
            }
            throw new NoSuchFileOrDirectory(this.mSrc);
        }

        //Move or copy recursively
        if (d.exists()) {
            try {
                TFile.cp_r(s, d, SecureConsole.DETECTOR, SecureConsole.DETECTOR);
            } catch (IOException ex) {
                throw new ExecutionException("Failed to move file or directory", ex);
            }
            if (!FileHelper.deleteFolder(s)) {
                if (isTrace()) {
                    Log.v(TAG, "Result: OK. WARNING. Source not deleted."); //$NON-NLS-1$
                }
            }
        } else {
            // Use rename. We are not cross filesystem with this console, so this operation
            // should be safe
            try {
                TFile.mv(s, d, SecureConsole.DETECTOR);
            } catch (IOException ex) {
                // Make sure truecrypt was right
                // There's a strange bug in it where it thinks that a file did not
                // move over. However, it actually did.
                if (!d.exists()) {
                    throw new ExecutionException("Failed to rename file or directory", ex);
                }
                if (s.exists() && d.exists()) {
                    if (!FileHelper.deleteFileOrFolder(s)) {
                        if (isTrace()) {
                            Log.v(TAG, "File copied successfully but not deleted"); //$NON-NLS-1$
                        }
                    }
                }
            }
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

