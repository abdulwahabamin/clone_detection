    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws NoSuchFileOrDirectory, ExecutionException {
        if (isTrace()) {
            Log.v(TAG,
                    String.format("Moving from %s to %s", //$NON-NLS-1$
                            this.mSrc, this.mDst));
        }

        TFile s = getConsole().buildRealFile(this.mSrc);
        TFile d = getConsole().buildRealFile(this.mDst);
        if (!s.exists()) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. NoSuchFileOrDirectory"); //$NON-NLS-1$
            }
            throw new NoSuchFileOrDirectory(this.mSrc);
        }

        try {
            TFile.cp_r(s, d, SecureConsole.DETECTOR, SecureConsole.DETECTOR);
        } catch (IOException ex) {
            throw new ExecutionException("Failed to copy file or directory", ex);
        }

        if (isTrace()) {
            Log.v(TAG, "Result: OK"); //$NON-NLS-1$
        }
    }

