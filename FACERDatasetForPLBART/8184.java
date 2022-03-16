    /**
     * Method that sets if the editor is dirty (has changed)
     *
     * @param dirty If the editor is dirty
     * @hide
     */
    void setDirty(boolean dirty) {
        this.mDirty = dirty;
        this.mSave.setVisibility(dirty ? View.VISIBLE : View.GONE);
    }

