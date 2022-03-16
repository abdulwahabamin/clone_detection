    private void performUserFlow() {
        List<LinkedResource> selection = new ArrayList<LinkedResource>();
        File hiddenCacheDirectory = new File(mContext.getExternalCacheDir(), CACHE_DIR);
        // Check if the hidden directory exists
        if (!hiddenCacheDirectory.exists()) {
            hiddenCacheDirectory.mkdirs();
        }
        final File tmpFso = new File(hiddenCacheDirectory, mFso.getName());
        selection.add(new LinkedResource(new File(mFso.getFullPath()), tmpFso));
        CopyMoveActionPolicy.copyFileSystemObjects(mContext, selection,
                new SecureChoiceSelectionListener(tmpFso),
                new SecureChoiceRefreshListener(tmpFso, mListener));

    }

