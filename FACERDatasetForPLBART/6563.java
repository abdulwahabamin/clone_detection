    /**
     * Set given document as target for in-place writing if user hits save
     * without changing the filename. Can be set to {@code null} if user
     * navigates outside the target directory.
     */
    public void setReplaceTarget(DocumentInfo replaceTarget) {
        mReplaceTarget = replaceTarget;

        if (mReplaceTarget != null) {
            getArguments().putString(EXTRA_DISPLAY_NAME, replaceTarget.displayName);
            mIgnoreNextEdit = true;
            mDisplayName.setText(replaceTarget.displayName);
        }
    }

